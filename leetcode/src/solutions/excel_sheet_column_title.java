package solutions;

public class excel_sheet_column_title {
	public String convertToTitle(int columnNumber) {
		StringBuilder sb = new StringBuilder();

		while(columnNumber > 0) {
			sb.append((char)('A' + (columnNumber - 1) % 26 ));
			// System.out.println(columnNumber + " " + sb.reverse().toString());
			columnNumber = (columnNumber - 1) / 26;
		}

		return sb.reverse().toString();
	}
}
