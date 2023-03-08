package com.royal.filetracking.tryone.helper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.royal.filetracking.tryone.model.Tutorial;

public class ExcelHelper {
//	public static final String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheet";
	public static final String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	/*
	 * Whether a given file is excel.
	 */
	public static boolean hasExcelFormat(MultipartFile file) {
//		if(TYPE.equals(file.getContentType())) {
//			return true;
//		} else {
//			return false;
//		}
		// TODO Making all file as excel file.
		return true;
	}
	
	
	public static List<Tutorial> excelToTutorials(InputStream is){
		try {
			Workbook workbook = new XSSFWorkbook(is);
//			Sheet sheet = workbook.getSheet("Tuto1");
			Sheet sheet = workbook.getSheetAt(0);
			

			Iterator<Row> rows = sheet.iterator();
			
			List<Tutorial> tutorials = new ArrayList<>();
			
			int rowNumber = 0;
			while(rows.hasNext()) {
				Row currentRow = rows.next();
				
				//skip the header
				if(rowNumber == 0) {
					rowNumber++;
					continue;
				}
				
				Iterator<Cell> cellsInRow = currentRow.iterator();
				Tutorial tutorial = new Tutorial();
				
				int cellIdx = 0;
				while(cellsInRow.hasNext()) {
					Cell currentCell = cellsInRow.next();
					switch(cellIdx) {
					case 0:
						tutorial.setId((long) currentCell.getNumericCellValue());
						break;
					case 1:
						tutorial.setTitle(currentCell.getStringCellValue());
						break;
					case 2:
						tutorial.setDescription(currentCell.getStringCellValue());
						break;
					case 3:
						tutorial.setPublished(currentCell.getBooleanCellValue());
						break;
					default:
						break;
					}
					cellIdx++;
				}
				// add tutorial to list.
				tutorials.add(tutorial);
			}
			workbook.close();
			
			return tutorials;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
