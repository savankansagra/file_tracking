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

public class GSPRINKPendingSupplierHelper {

	public static List<GSPRINKPendingSupplier> excelToGSPRINKPendingSupplier(InputStream inputStream) throws IOException {
		List<GSPRINKPendingSupplier> listOfGSPRINKPendingSupplier = new ArrayList<>();
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
				GSPRINKPendingSupplier gsprinkPendingSupplier = getPendingSupplierFromRow(currentRow);
				listOfGSPRINKPendingSupplier.add(gsprinkPendingSupplier);
				rowNumber++;
			}
			
			
 		} catch (Exception e) {
 			e.printStackTrace();
		} finally {
			workbook.close();
		}
		return listOfGSPRINKPendingSupplier;
	}

	private static GSPRINKPendingSupplier getPendingSupplierFromRow(Row currentRow) {
		GSPRINKPendingSupplier gsprinkPendingSupplier = new GSPRINKPendingSupplier();
		int cellIndex=0;
		
		Iterator<Cell> cellsInRow = currentRow.iterator();
		while(cellsInRow.hasNext()) {
			Cell currentCell = cellsInRow.next();
			switch (cellIndex) {
			case 0: {
				gsprinkPendingSupplier.setRegNo(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 1: {
				gsprinkPendingSupplier.setRegDate(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 2: {
				gsprinkPendingSupplier.setApplDate(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Date.class));
				break;
			}
			case 3: {
				gsprinkPendingSupplier.setFarmerName(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 4: {
				gsprinkPendingSupplier.setSupplier(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 5: {
				gsprinkPendingSupplier.setMisSystem(ExcelHelper.getSpecificTypeValueFromCell(currentCell,String.class));
				break;
			}
			case 6: {
				gsprinkPendingSupplier.setLoanneNonLoanee(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 7: {
				gsprinkPendingSupplier.setAreaHec(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Double.class));
				break;
			}
			case 8: {
				gsprinkPendingSupplier.setBack(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 9: {
				gsprinkPendingSupplier.setRmkBackToGSprink(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			default: 
				break;
			}
			cellIndex++;
		}
		return gsprinkPendingSupplier;
	}
	
}
