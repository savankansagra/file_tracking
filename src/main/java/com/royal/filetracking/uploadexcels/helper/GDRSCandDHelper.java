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

import com.royal.filetracking.uploadexcels.model.GDRSCandD;

public class GDRSCandDHelper {

	public static List<GDRSCandD> excelToGDRSCandD(InputStream inputStream) throws IOException {
		List<GDRSCandD> listOfCandD = new ArrayList<>();
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
				GDRSCandD gdrsCandD = getCandDFromRow(currentRow);
				listOfCandD.add(gdrsCandD);
				rowNumber++;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			workbook.close();
		}
		return listOfCandD;
	}

	private static GDRSCandD getCandDFromRow(Row currentRow) {
		GDRSCandD gdrsCandD = new GDRSCandD();
		int cellIndex=0;
		
		Iterator<Cell> cellsInRow = currentRow.iterator();
		while(cellsInRow.hasNext()) {
			Cell currentCell = cellsInRow.next();
			switch (cellIndex) {
			case 0: {
				gdrsCandD.setRegNo(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 1: {
				gdrsCandD.setRegDate(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Date.class));
				break;
			}
			case 2: {
				gdrsCandD.setApplDate(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Date.class));
				break;
			}
			case 3: {
				gdrsCandD.setFarmerName(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 4: {
				gdrsCandD.setSupplier(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 5: {
				gdrsCandD.setMisSystem(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 6: {
				gdrsCandD.setLoanneNonLoanee(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 7: {
				gdrsCandD.setAreaHec(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Double.class));
				break;
			}
			case 8: {
				gdrsCandD.setBack(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 9: {
				gdrsCandD.setLastscan(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 10: {
				gdrsCandD.setInwardDt(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Date.class));
				break;
			}
			default:
				break;
			}
			cellIndex++;
		}
		return gdrsCandD;
	}

}
