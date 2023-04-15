package com.royal.filetracking.uploadexcels.helper.GSPRINK;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.royal.filetracking.uploadexcels.helper.ExcelHelper;
import com.royal.filetracking.uploadexcels.model.GDRS.GDRSPendingSupplier;
import com.royal.filetracking.uploadexcels.model.GSPRINK.GSPRINKPendingSupplier;
import com.royal.filetracking.uploadexcels.model.GSPRINK.GSPRINKRegistrationCDPending;

public class GSPRINKRegistrationCDPendingHelper {

	public static List<GSPRINKRegistrationCDPending> excelToGSPRINKRegistrationCDPending(InputStream inputStream) throws IOException {
		List<GSPRINKRegistrationCDPending> listOfGSPRINKRegistrationCDPending = new ArrayList<>();
		Workbook workbook = new XSSFWorkbook(inputStream);
		try {
			Sheet sheet = workbook.getSheetAt(workbook.getActiveSheetIndex());
			Iterator<Row> rows = sheet.iterator();
			int rowNumber = 0;
			while(rows.hasNext()) {
				Row currentRow = rows.next();
				//skip the header
				if(rowNumber == 0) {
					rowNumber++;
					continue;
				}
				GSPRINKRegistrationCDPending gsprinkPendingSupplier = getRegistrationCDPendingFromRow(currentRow);
				listOfGSPRINKRegistrationCDPending.add(gsprinkPendingSupplier);
				rowNumber++;
			}
 		} catch (Exception e) {
 			e.printStackTrace();
		} finally {
			workbook.close();
		}
		return listOfGSPRINKRegistrationCDPending;
	}

	private static GSPRINKRegistrationCDPending getRegistrationCDPendingFromRow(Row currentRow) {
		GSPRINKRegistrationCDPending gsprinkRegistrationCDPending = new GSPRINKRegistrationCDPending();
		int cellIndex=0;
		
		Iterator<Cell> cellsInRow = currentRow.iterator();
		while(cellsInRow.hasNext()) {
			Cell currentCell = cellsInRow.next();
			switch (cellIndex) {
			case 0: {
				gsprinkRegistrationCDPending.setRegNo(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 1: {
				gsprinkRegistrationCDPending.setRegDate(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 2: {
				gsprinkRegistrationCDPending.setApplDate(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Date.class));
				break;
			}
			case 3: {
				gsprinkRegistrationCDPending.setFarmerName(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 4: {
				gsprinkRegistrationCDPending.setSupplier(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 5: {
				gsprinkRegistrationCDPending.setMisSystem(ExcelHelper.getSpecificTypeValueFromCell(currentCell,String.class));
				break;
			}
			case 6: {
				gsprinkRegistrationCDPending.setLoanneNonLoanee(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 7: {
				gsprinkRegistrationCDPending.setAreaHec(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Double.class));
				break;
			}
			case 8: {
				gsprinkRegistrationCDPending.setBack(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 9: {
				gsprinkRegistrationCDPending.setRmkBackToGSprink(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			default: 
				break;
			}
			cellIndex++;
		}
		return gsprinkRegistrationCDPending;
	}
	
}
