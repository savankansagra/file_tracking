package com.royal.filetracking.uploadexcels.helper;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.aspectj.weaver.ast.Var;

import com.royal.filetracking.uploadexcels.model.GDRSNewRegistation;


public class GDRSNewRegistrationHelper {
	
	/**
	 * Convert Excel to GDRSNewRegistration DBOs.
	 * 
	 * @param inputStream
	 * @return
	 * @throws IOException 
	 */
	public static List<GDRSNewRegistation> excelToGDRSNewRegistration(InputStream inputStream) throws IOException {
		List<GDRSNewRegistation> listOfGDRSNewRegistration = new ArrayList<>();
		Workbook workbook = new XSSFWorkbook(inputStream);
		try {
			Sheet sheet = workbook.getSheetAt(workbook.getActiveSheetIndex());
			Iterator<Row> rows=sheet.iterator();
			int rowNumber = 0;
			while(rows.hasNext()) {
				Row currentRow = rows.next();
				//skip the header
				if(rowNumber == 0) {
					rowNumber++;
					continue;
				}
				GDRSNewRegistation gdrsNewRegistation = getGDRSNewRegistrationFromRow(currentRow);
				listOfGDRSNewRegistration.add(gdrsNewRegistation);
				rowNumber++;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			workbook.close();
		}
		return listOfGDRSNewRegistration;
	}

	
	/**
	 * Convert Row to GDRSNewRegistration Obejct.
	 * 
	 * @param currentRow
	 * @return
	 * @throws ParseException 
	 */
	private static GDRSNewRegistation getGDRSNewRegistrationFromRow(Row currentRow) throws ParseException {
		GDRSNewRegistation gdrsNewRegistation = new GDRSNewRegistation();
		int cellIndex = 0;
		
		Iterator<Cell> cellsInRow = currentRow.iterator();
		while(cellsInRow.hasNext()) {
			Cell currentCell = cellsInRow.next();
			switch (cellIndex) {
			case 0: {
				gdrsNewRegistation.setRegNo(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Long.class));
				break;
			}
			case 1: {
				gdrsNewRegistation.setRegDate(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Integer.class));
				break;
			}
			case 2: {
				gdrsNewRegistation.setApplDate(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Date.class));
				break;
			}
			case 3: {
				gdrsNewRegistation.setFarmerName(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 4: {
				gdrsNewRegistation.setSupplier(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 5: {
				gdrsNewRegistation.setMisSystem(ExcelHelper.getSpecificTypeValueFromCell(currentCell,String.class));
				break;
			}
			case 6: {
				gdrsNewRegistation.setLoanneNonLoanee(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 7: {
				gdrsNewRegistation.setAreaHec(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Double.class));
				break;
			}
			case 8: {
				gdrsNewRegistation.setLastScan(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 9: {
				gdrsNewRegistation.setDistrict(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 10: {
				gdrsNewRegistation.setDistrictId(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Integer.class));
				break;
			}
			case 11: {
				gdrsNewRegistation.setTaluka(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 12: {
				gdrsNewRegistation.setTalukaId(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Integer.class));
				break;
			}
			case 13: {
				gdrsNewRegistation.setVillage(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 14: {
				gdrsNewRegistation.setSchemeDesc(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 15: {
				gdrsNewRegistation.setGuvnlSchemeId(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Integer.class));
				break;
			}
			case 16: {
				gdrsNewRegistation.setSurveyNo(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 17: {
				gdrsNewRegistation.setMisArea1(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Double.class));
				break;
			}
			case 18: {
				gdrsNewRegistation.setSurveyNo1(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 19: {
				gdrsNewRegistation.setBack(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 20: {
				gdrsNewRegistation.setFarmerContactNo(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Long.class));
				break;
			}
			case 21: {
				gdrsNewRegistation.setBorewell(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}

			default:
				break;
			}
			cellIndex++;
		}
		return gdrsNewRegistation;
	}

}
