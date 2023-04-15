package com.royal.filetracking.uploadexcels.helper.GWORKS;

import java.io.IOException;
import java.io.InputStream;import java.lang.reflect.Executable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.boot.context.properties.source.MutuallyExclusiveConfigurationPropertiesException;

import com.royal.filetracking.uploadexcels.helper.ExcelHelper;
import com.royal.filetracking.uploadexcels.model.GWORKS.GWORKSInspClrd;
import com.royal.filetracking.uploadexcels.model.GWORKS.GWORKSInspNotInstalled;
import com.royal.filetracking.uploadexcels.model.GWORKS.GWORKSInspSent;
import com.royal.filetracking.uploadexcels.model.GWORKS.GWORKSInvoiceSent;
import com.royal.filetracking.uploadexcels.model.GWORKS.GWORKSWoRcvd;

public class GWORKSInvoiceSentHelper {

	public static List<GWORKSInvoiceSent> excelToGWORKSInvoiceSent(InputStream inputStream) throws IOException {
		List<GWORKSInvoiceSent> listOfGWORKSInvoiceSent = new ArrayList<>();
		Workbook workbook = new XSSFWorkbook(inputStream);
		try {
			Sheet sheet = workbook.getSheetAt(workbook.getActiveSheetIndex());
			Iterator<Row> rows = sheet.iterator();
			int rowNumber = 0;
			while(rows.hasNext()) {
				Row currentRow = rows.next();
				// skip the header
				if(rowNumber == 0) {
					rowNumber++;
					continue;
				}
				// start
				GWORKSInvoiceSent gworksInvoiceSent = getInvoiceSentFromRow(currentRow);
				listOfGWORKSInvoiceSent.add(gworksInvoiceSent);
				rowNumber++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			workbook.close();
		}
		return listOfGWORKSInvoiceSent;
	}

	private static GWORKSInvoiceSent getInvoiceSentFromRow(Row currentRow) {
		GWORKSInvoiceSent gworksInvoiceSent = new GWORKSInvoiceSent();
		int cellindex = 0;
		
		Iterator<Cell> cellsInRow = currentRow.iterator();
		while(cellsInRow.hasNext()) {
			Cell currentCell = cellsInRow.next();
			switch(cellindex) {
			case 0: {
				gworksInvoiceSent.setRegNo(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 1: {
				gworksInvoiceSent.setRegDate(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Date.class));
				break;
			}
			case 2: {
				gworksInvoiceSent.setTaluka(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 3: {
				gworksInvoiceSent.setVillage(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 4: {
				gworksInvoiceSent.setInvoiceSentDate(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Date.class));
				break;
			}
			case 5: {
				gworksInvoiceSent.setTwentyFiveRelDt(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 6: {
				gworksInvoiceSent.setFarmerName(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 7: {
				gworksInvoiceSent.setMisSystem(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 8: {
				gworksInvoiceSent.setLoanneNonLoanee(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 9: {
				gworksInvoiceSent.setAreaHec(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Double.class));
				break;
			}
			case 10: {
				gworksInvoiceSent.setStatus(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 11: {
				gworksInvoiceSent.setGps(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 12: {
				gworksInvoiceSent.setInspectionDate(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Date.class));
				break;
			}
			case 13: {
				gworksInvoiceSent.setEstMisCost(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Double.class));
				break;
			}
			case 14: {
				gworksInvoiceSent.setFpInwardDate(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 15: {
				gworksInvoiceSent.setInvoicePhysicalVerificationDate(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 16: {
				gworksInvoiceSent.setTrVerifiedDt(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			default: 
				break;
			}
			cellindex++;
		}
		return gworksInvoiceSent;
	}

	
}
