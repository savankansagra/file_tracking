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
import com.royal.filetracking.uploadexcels.model.GWORKS.GWORKSInspNotInstalled;
import com.royal.filetracking.uploadexcels.model.GWORKS.GWORKSInspSent;
import com.royal.filetracking.uploadexcels.model.GWORKS.GWORKSWoRcvd;

public class GWORKSInspNotInstalledHelper {

	public static List<GWORKSInspNotInstalled> excelToGWORKSInspNotInstalled(InputStream inputStream) throws IOException {
		List<GWORKSInspNotInstalled> listOfGWORKSInspNotInstalled = new ArrayList<>();
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
				GWORKSInspNotInstalled gworksInspNotInstalled = getInspNotInstalledFromRow(currentRow);
				listOfGWORKSInspNotInstalled.add(gworksInspNotInstalled);
				rowNumber++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			workbook.close();
		}
		
		return listOfGWORKSInspNotInstalled;
	}

	private static GWORKSInspNotInstalled getInspNotInstalledFromRow(Row currentRow) {
		GWORKSInspNotInstalled gworksInspNotInstalled = new GWORKSInspNotInstalled();
		int cellindex = 0;
		
		Iterator<Cell> cellsInRow = currentRow.iterator();
		while(cellsInRow.hasNext()) {
			Cell currentCell = cellsInRow.next();
			switch(cellindex) {
			case 0: {
				gworksInspNotInstalled.setRegNo(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 1: {
				gworksInspNotInstalled.setRegDate(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Date.class));
				break;
			}
			case 2: {
				gworksInspNotInstalled.setTaluka(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 3: {
				gworksInspNotInstalled.setVillage(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 4: {
				gworksInspNotInstalled.setNotInstalledDt(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Date.class));
				break;
			}
			case 5: {
				gworksInspNotInstalled.setFarmerName(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 6: {
				gworksInspNotInstalled.setInspectionAgency(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 7: {
				gworksInspNotInstalled.setMisSystem(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 8: {
				gworksInspNotInstalled.setLoanneNonLoanee(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 9: {
				gworksInspNotInstalled.setAreaHec(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Double.class));
				break;
			}
			case 10: {
				gworksInspNotInstalled.setStatus(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 11: {
				gworksInspNotInstalled.setSystemNotInstalledRemarks(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 12: {
				gworksInspNotInstalled.setEstMisCose(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Double.class));
				break;
			}
			case 13: {
				gworksInspNotInstalled.setMisCostExclusive(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Double.class));
				break;
			}
			case 14: {
				gworksInspNotInstalled.setInspectionChrg(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Double.class));
				break;
			}
			case 15: {
				gworksInspNotInstalled.setType(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Integer.class));
				break;
			}
			case 16: {
				gworksInspNotInstalled.setAbortRemarks(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 17: {
				gworksInspNotInstalled.setSourceOfApplication(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 18: {
				gworksInspNotInstalled.setSevenYearCase(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			default: 
				break;
			}
			cellindex++;
		}
		return gworksInspNotInstalled;
	}

	
}
