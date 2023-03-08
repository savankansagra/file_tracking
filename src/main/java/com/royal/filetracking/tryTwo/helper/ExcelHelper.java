package com.royal.filetracking.tryTwo.helper;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.multipart.MultipartFile;

import com.royal.filetracking.tryTwo.model.GDRSNewRegistation;

public class ExcelHelper {

	public static final String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	
	/**
	 * Whether given file is in specific format.
	 * 
	 * @param file
	 * @return
	 */
	public static boolean hasExcelFormat(MultipartFile file) {
		// TODO Make format for all the files
//		if(TYPE.equals(file.getContentType())) {
//		return true;
//	} else {
//		return false;
//	}
		return true;
	}
	

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
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
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
				gdrsNewRegistation.setRegNo(getSpecificTypeValueFromCell(currentCell, Long.class));
				break;
			}
			case 1: {
				gdrsNewRegistation.setRegDate(getSpecificTypeValueFromCell(currentCell, Integer.class));
				break;
			}
			case 2: {
				gdrsNewRegistation.setApplDate(getSpecificTypeValueFromCell(currentCell, Date.class));
				break;
			}
			case 3: {
				gdrsNewRegistation.setFarmerName(getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 4: {
				gdrsNewRegistation.setSupplier(getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 5: {
				gdrsNewRegistation.setMisSystem(getSpecificTypeValueFromCell(currentCell,String.class));
				break;
			}
			case 6: {
				gdrsNewRegistation.setLoanneNonLoanee(getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 7: {
				gdrsNewRegistation.setAreaHec(getSpecificTypeValueFromCell(currentCell, Double.class));
				break;
			}
			case 8: {
				gdrsNewRegistation.setLastScan(getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 9: {
				gdrsNewRegistation.setDistrict(getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 10: {
				gdrsNewRegistation.setDistrictId(getSpecificTypeValueFromCell(currentCell, Integer.class));
				break;
			}
			case 11: {
				gdrsNewRegistation.setTaluka(getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 12: {
				gdrsNewRegistation.setTalukaId(getSpecificTypeValueFromCell(currentCell, Integer.class));
				break;
			}
			case 13: {
				gdrsNewRegistation.setVillage(getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 14: {
				gdrsNewRegistation.setSchemeDesc(getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 15: {
				gdrsNewRegistation.setGuvnlSchemeId(getSpecificTypeValueFromCell(currentCell, Integer.class));
				break;
			}
			case 16: {
				gdrsNewRegistation.setSurveyNo(getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 17: {
				gdrsNewRegistation.setMisArea1(getSpecificTypeValueFromCell(currentCell, Double.class));
				break;
			}
			case 18: {
				gdrsNewRegistation.setSurveyNo1(getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 19: {
				gdrsNewRegistation.setBack(getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 20: {
				gdrsNewRegistation.setFarmerContactNo(getSpecificTypeValueFromCell(currentCell, Long.class));
				break;
			}
			case 21: {
				gdrsNewRegistation.setBorewell(getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}

			default:
				break;
			}
			cellIndex++;
		}
		return gdrsNewRegistation;
	}
	
	
	private static String getStringValueOfCell(Cell cell){
		if(cell.getCellType() == CellType.STRING) {
			return cell.getStringCellValue();
		} else {
			return String.valueOf(cell.getNumericCellValue());
		}
	}
	
	
	private static <E> E getSpecificTypeValueFromCell(Cell cell, Class<E> className) throws ParseException {
		// below formatter return string value regardless of cell type.
		// reference. https://www.callicoder.com/java-read-excel-file-apache-poi/
		DataFormatter dataFormatter = new DataFormatter();
		String cellValue = dataFormatter.formatCellValue(cell);
		if(className == String.class) {
			return (E) cellValue;
		} else if(className == Long.class) {
			return (E) Long.valueOf(cellValue);
		} else if(className == Double.class) {
			return (E) Double.valueOf(cellValue);
		} else if(className == Integer.class) {
			return (E) Integer.valueOf(cellValue);
		} else if(className == Date.class) {
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			Date date = formatter.parse(cellValue);
			return (E) date;
		}
		return null;
	}
	
	
	
}