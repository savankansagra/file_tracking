package com.royal.filetracking.uploadexcels.helper.GDRS;

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
import com.royal.filetracking.uploadexcels.model.GDRS.GDRSCandDCleared;
import com.royal.filetracking.uploadexcels.model.GDRS.GDRSCandDSent;

public class GDRSCandDClearedHelper {

	public static List<GDRSCandDCleared> excelToGDRSCandDCleared(InputStream inputStream) throws IOException {
		List<GDRSCandDCleared> listOfCandDCleared = new ArrayList<>();
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
				GDRSCandDCleared gdrsCandDCleared = getCandDClearedFromRow(currentRow);
				listOfCandDCleared.add(gdrsCandDCleared);
				rowNumber++;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			workbook.close();
		}
		return listOfCandDCleared;
	}

	private static GDRSCandDCleared getCandDClearedFromRow(Row currentRow) {
		GDRSCandDCleared gdrsCandDCleared = new GDRSCandDCleared();
		int cellIndex=0;
		
		Iterator<Cell> cellsInRow = currentRow.iterator();
		while(cellsInRow.hasNext()) {
			Cell currentCell = cellsInRow.next();
			switch (cellIndex) {
			case 0: {
				gdrsCandDCleared.setRegNo(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 1: {
				gdrsCandDCleared.setRegDate(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Date.class));
				break;
			}
			case 2: {
				gdrsCandDCleared.setApplDate(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Date.class));
				break;
			}
			case 3: {
				gdrsCandDCleared.setFarmerName(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 4: {
				gdrsCandDCleared.setSupplier(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 5: {
				gdrsCandDCleared.setMisSystem(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 6: {
				gdrsCandDCleared.setLoanneNonLoanee(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 7: {
				gdrsCandDCleared.setAreaHec(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Double.class));
				break;
			}
			case 8: {
				gdrsCandDCleared.setBack(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 9: {
				gdrsCandDCleared.setLastscan(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 10: {
				gdrsCandDCleared.setInwardDt(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Date.class));
				break;
			}
			default:
				break;
			}
			cellIndex++;
		}
		return gdrsCandDCleared;
	}

}
