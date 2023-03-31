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

import com.royal.filetracking.uploadexcels.model.GDRSCandDSent;

public class GDRSCandDSentHelper {

	public static List<GDRSCandDSent> excelToGDRSCandDSent(InputStream inputStream) throws IOException {
		List<GDRSCandDSent> listOfCandDSent = new ArrayList<>();
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
				GDRSCandDSent gdrsCandD = getCandDSentFromRow(currentRow);
				listOfCandDSent.add(gdrsCandD);
				rowNumber++;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			workbook.close();
		}
		return listOfCandDSent;
	}

	private static GDRSCandDSent getCandDSentFromRow(Row currentRow) {
		GDRSCandDSent gdrsCandDSent = new GDRSCandDSent();
		int cellIndex=0;
		
		Iterator<Cell> cellsInRow = currentRow.iterator();
		while(cellsInRow.hasNext()) {
			Cell currentCell = cellsInRow.next();
			switch (cellIndex) {
			case 0: {
				gdrsCandDSent.setRegNo(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 1: {
				gdrsCandDSent.setRegDate(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Date.class));
				break;
			}
			case 2: {
				gdrsCandDSent.setApplDate(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Date.class));
				break;
			}
			case 3: {
				gdrsCandDSent.setFarmerName(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 4: {
				gdrsCandDSent.setSupplier(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 5: {
				gdrsCandDSent.setMisSystem(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 6: {
				gdrsCandDSent.setLoanneNonLoanee(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 7: {
				gdrsCandDSent.setAreaHec(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Double.class));
				break;
			}
			case 8: {
				gdrsCandDSent.setBack(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 9: {
				gdrsCandDSent.setLastscan(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 10: {
				gdrsCandDSent.setInwardDt(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Date.class));
				break;
			}
			default:
				break;
			}
			cellIndex++;
		}
		return gdrsCandDSent;
	}

}
