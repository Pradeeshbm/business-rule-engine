package com.example.pe.businessrule.payment.postprocessor;

import java.util.ArrayList;
import java.util.List;

import com.example.pe.businessrule.model.Item;
import com.example.pe.businessrule.model.PhysicalProduct;
import com.example.pe.businessrule.model.Slip;

import lombok.extern.slf4j.Slf4j;

/**
 * Generate a packing slip for shipping
 * 
 * @author pradeesh.kumar
 */
@Slf4j
public class PackingSlipPostProcessor implements PaymentPostProcessor {

	@Override
	public void process(Item item) {
		log.info("Generating packing slip for the product: {}", item.getItemName());
		List<String> lineItems = createSlipLineItems(item);
		Slip slip = new Slip();
		slip.setLineItems(lineItems);
		item.setSlip(slip);
	}
	
	/**
	 * Creates the slip line items.
	 *
	 * @param item the item
	 * @return the list
	 */
	private static List<String> createSlipLineItems(Item item) {
		PhysicalProduct physicalProduct = (PhysicalProduct) item;
		List<String> lineItems = new ArrayList<>();
		
		lineItems.add("\n--------------PACKING SLIP--------------\n");
		lineItems.add("Name of item: " + item.getItemName() + "\n");
		lineItems.add("Width: " + physicalProduct.getWeight() + "\n");
		lineItems.add("Height: " + physicalProduct.getHeight() + "\n");
		lineItems.add("Weight: " + physicalProduct.getWeight() + "\n");
		lineItems.add("Price: " + item.getPrice() + "\n");
		lineItems.add("--------------END OF SLIP--------------\n");
		System.out.println("\n\n" + lineItems.toString() + "\n\n");
		return lineItems;
	}

}
