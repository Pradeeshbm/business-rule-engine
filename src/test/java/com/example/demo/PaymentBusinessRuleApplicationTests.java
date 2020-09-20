package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.pe.businessrule.PaymentBusinessRuleApplication;
import com.example.pe.businessrule.exception.PaymentException;
import com.example.pe.businessrule.model.Book;
import com.example.pe.businessrule.model.Laptop;
import com.example.pe.businessrule.model.Membership;
import com.example.pe.businessrule.model.Membership.MembershipStatus;
import com.example.pe.businessrule.model.PhysicalProduct;
import com.example.pe.businessrule.model.Video;
import com.example.pe.businessrule.payment.PaymentDelegate;

@SpringBootTest(classes = PaymentBusinessRuleApplication.class)
public class PaymentBusinessRuleApplicationTests {
	
	@Autowired
	private PaymentDelegate paymentDelegate;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void testPayment_PriceFailure() {
		Laptop book = new Laptop("Dell");
		book.setHeight(100);
		book.setWeight(50);
		book.setWeight(20);
		assertThrows(PaymentException.class, () -> paymentDelegate.pay(book), "I'm expecting exception to be thrown when price is zero");
	}
	
	@Test
	public void testPayment_NullFailure() {
		assertThrows(NullPointerException.class, () -> paymentDelegate.pay(null), "I'm expecting exception to be thrown when item is null");
	}
	
	@Test
	public void testBookPayment_Success() {
		Book book = new Book("ISBN-1234", "Paulo Coelo", "Penguine Book Publisher");
		book.setHeight(100);
		book.setWeight(50);
		book.setWeight(20);
		book.setPrice(329);
		book.setUserId(123);
		paymentDelegate.pay(book);
		assertNotNull(book.getSlip(), "I'm expecting slip to be present once the payment is made.");
		assertNotNull(book.getSlip().getLineItems(), "I'm expecting line items to be present in the slip");
		assertTrue(book.getSlip().getLineItems().size() > 0, "I'm expecting line item atleast contains 1 line");
	}
	
	@Test
	public void testPhysicalProductPayment_Success() {
		PhysicalProduct laptop = new Laptop("Dell");
		laptop.setItemName("Dell inspiron");
		laptop.setHeight(100);
		laptop.setWeight(50);
		laptop.setWeight(20);
		laptop.setPrice(329);
		laptop.setUserId(123);
		paymentDelegate.pay(laptop);
		assertNotNull(laptop.getSlip(), "I'm expecting slip to be present once the payment is made.");
		assertNotNull(laptop.getSlip().getLineItems(), "I'm expecting line items to be present in the slip");
		assertTrue(laptop.getSlip().getLineItems().size() > 0, "I'm expecting line item atleast contains 1 line");
	}
	
	@Test
	public void testMembershipActivation_Success() {
		Membership m = new Membership();
		m.setItemName("Gold premier membership");
		m.setMembershipId(123);
		m.setPrice(32343);
		m.setStatus(MembershipStatus.NEW);
		m.setUserId(122);
		paymentDelegate.pay(m);
		assertTrue(m.getStatus() == MembershipStatus.ACTIVE, "I'm expecting membership status to be updated as ACTIVE for a new membership payment");
	}
	
	@Test
	public void testMembershipUpgrade_Success() {
		Membership m = new Membership();
		m.setItemName("Silver premier membership");
		m.setMembershipId(123);
		m.setPrice(32343);
		m.setStatus(MembershipStatus.UPGRADE);
		m.setUserId(122);
		paymentDelegate.pay(m);
		assertTrue(m.getStatus() == MembershipStatus.ACTIVE, "I'm expecting membership status to be updated as ACTIVE for an upgrade membership payment");
	}
	
	@Test
	public void testVideoPayment_Success() {
		Video v = new Video();
		v.setDuration(23);
		v.setItemName("Learning to Ski");
		v.setPrice(32);
		v.setUrl("https://example.com/video?id=123");
		assertDoesNotThrow(() -> paymentDelegate.pay(v), "I'm expecting payment to be successful without any exceptions");
	}
}
