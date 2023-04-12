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
import com.royal.filetracking.uploadexcels.model.GWORKS.GWORKSInspSent;
import com.royal.filetracking.uploadexcels.model.GWORKS.GWORKSWoRcvd;

public class GWORKSInspSentHelper {

	public static List<GWORKSInspSent> excelToGWORKSInspSent(InputStream inputStream) throws IOException {
		List<GWORKSInspSent> listOfGWORKSInspSent = new ArrayList<>();
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
				GWORKSInspSent gworksInspSent = getInspSentFromRow(currentRow);
				listOfGWORKSInspSent.add(gworksInspSent);
				rowNumber++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			workbook.close();
		}
		
		return listOfGWORKSInspSent;
	}

	private static GWORKSInspSent getInspSentFromRow(Row currentRow) {
		GWORKSInspSent gworksInspSent = new GWORKSInspSent();
		int cellindex = 0;
		
		Iterator<Cell> cellsInRow = currentRow.iterator();
		while(cellsInRow.hasNext()) {
			Cell currentCell = cellsInRow.next();
			switch(cellindex) {
			case 0: {
				gworksInspSent.setRegNo(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 1: {
				gworksInspSent.setRegDate(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Date.class));
				break;
			}
			case 2: {
				gworksInspSent.setTaluka(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 3: {
				gworksInspSent.setVillage(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 4: {
				gworksInspSent.setInspSentDt(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Date.class));
				break;
			}
			case 5: {
				gworksInspSent.setTwentyFiveRelDt(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 6: {
				gworksInspSent.setFarmerName(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 7: {
				gworksInspSent.setInspectionAgency(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 8: {
				gworksInspSent.setMisSystem(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 9: {
				gworksInspSent.setLoanneNonLoanee(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 10: {
				gworksInspSent.setAreaHec(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Double.class));
				break;
			}
			case 11: {
				gworksInspSent.setStatus(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 12: {
				gworksInspSent.setGps(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 13: {
				gworksInspSent.setInspectionDate(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 14: {
				gworksInspSent.setEstMisCose(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Double.class));
				break;
			}
			case 15: {
				gworksInspSent.setApprovedTpaDate(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Date.class));
				break;
			}
			default: 
				break;
			}
			cellindex++;
		}
		return gworksInspSent;
	}

	
}
