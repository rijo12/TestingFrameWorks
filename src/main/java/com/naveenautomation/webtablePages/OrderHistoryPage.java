package com.naveenautomation.webtablePages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class OrderHistoryPage extends TestBase {

	public OrderHistoryPage() {

		PageFactory.initElements(webDriver, this);
	}

	public WebElement getCellFromCustomerTable(String orderId, OrderHistoryTable column) {

		int columnIndex = getIndexForColumn(column);

		int orderIdColumnIndex = getIndexForColumn(OrderHistoryTable.ORDERID);

		if (columnIndex < 0) {

			return null;
		}
		// finding rows

		List<WebElement> rows = webDriver.findElements(By.cssSelector("div.table-responsive>table>tbody tr"));

		// iterating over rows to get the cells by tag name td

		for (int i = 1; i < rows.size(); i++) {

			List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));

			if (cells.size() < columnIndex || cells.size() < orderIdColumnIndex) {

				continue;
			}
			// get the first value using row
			// starting from leftmost column
			String[] devicesIds = cells.get(orderIdColumnIndex).getText().split("\n");

			for (int j = 0; j < devicesIds.length; j++) {
				
				if (devicesIds[j].equals(orderId)) {

					// Here returning the respective value using column index already found
					return cells.get(columnIndex);
				}
			}

		}

		System.out.println(String.format("Can't find row, which contains Company name = %s" + orderId));

		return null;

	}

	private int getIndexForColumn(OrderHistoryTable column) {
		
		List<WebElement> headers = null;

		headers = webDriver.findElements(By.cssSelector("div.table-responsive>table>thead>tr td"));
		
		for (WebElement header : headers) {
			
			if (column.getText().equals(header.getText())) {
				
				return headers.indexOf(header);

			}
		}

		return -1;
	}

	public enum OrderHistoryTable {
		ORDERID("Order ID"), CUSTOMER("Customer"), NOOFPRODUCTS("No. of Products"), STATUS("Status"), TOTAL("Total"),
		DATEADDED("Date Added");

		private String value;

		OrderHistoryTable(String value) {
			this.value = value;
		}

		public String getText() {
			return value;
		}

	}

}
