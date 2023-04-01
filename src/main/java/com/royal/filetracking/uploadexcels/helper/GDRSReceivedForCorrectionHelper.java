package com.royal.filetracking.uploadexcels.helper;

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

import com.royal.filetracking.uploadexcels.model.GDRSCandDCleared;
import com.royal.filetracking.uploadexcels.model.GDRSCandDSent;
import com.royal.filetracking.uploadexcels.model.GDRSReceivedForCorrection;

public class GDRSReceivedForCorrectionHelper {

	public static List<GDRSReceivedForCorrection> excelToGDRSReceivedForCorrections(InputStream inputStream) throws IOException {
		List<GDRSReceivedForCorrection> listOfReceivedForCorrection = new ArrayList<>();
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
				GDRSReceivedForCorrection gdrsReceivedForCorrection = getReceivedForCorrectionFromRow(currentRow);
				listOfReceivedForCorrection.add(gdrsReceivedForCorrection);
				rowNumber++;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			workbook.close();
		}
		return listOfReceivedForCorrection;
	}

	private static GDRSReceivedForCorrection getReceivedForCorrectionFromRow(Row currentRow) {
		GDRSReceivedForCorrection gdrsReceivedForCorrection = new GDRSReceivedForCorrection();
		int cellIndex=0;
		
		Iterator<Cell> cellsInRow = currentRow.iterator();
		while(cellsInRow.hasNext()) {
			Cell currentCell = cellsInRow.next();
			switch (cellIndex) {
			case 0: {
				gdrsReceivedForCorrection.setRegNo(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 1: {
				gdrsReceivedForCorrection.setRegDate(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 2: {
				gdrsReceivedForCorrection.setApplDate(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Date.class));
				break;
			}
			case 3: {
				gdrsReceivedForCorrection.setFarmerName(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 4: {
				gdrsReceivedForCorrection.setSupplier(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 5: {
				gdrsReceivedForCorrection.setMisSystem(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 6: {
				gdrsReceivedForCorrection.setLoanneNonLoanee(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 7: {
				gdrsReceivedForCorrection.setAreaHec(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Double.class));
				break;
			}
			case 8: {
				gdrsReceivedForCorrection.setBack(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 9: {
				gdrsReceivedForCorrection.setLastscan(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			default:
				break;
			}
			cellIndex++;
		}
		return gdrsReceivedForCorrection;
	}

}
