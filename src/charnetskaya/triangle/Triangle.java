package charnetskaya.triangle;

public class Triangle {

	private int height;
	private String[][] triangle;

	public Triangle(Integer height) {

		this.height = height;
		setUpTriangle();

	}

	private void setUpTriangle() {
		Integer length = 1;

		for (int i = length; i < height; i++) {
			length += 2;
		}
		triangle = new String[height][length];

		/*
		 * for (int a = 0; a < height; a++) { for (int b = 0; b < length; b++) {
		 * triangle[a][b] = " ";
		 * 
		 * } }
		 */

		for (int c = 0; c < triangle[height - 1].length; c++) {
			triangle[height - 1][c] = "*";
		}

		int numSpaces = 0;
		height -= 2;
		while (height >= 0) {

			length -= 1;

			int begin = 0;
			int end = length - 1;

			while (begin < end) {
				triangle[height][begin] = " ";
				begin++;
			}

			triangle[height][numSpaces + 1] = "*";
			triangle[height][length - 1] = "*";

			numSpaces += 1;

			height--;
		}

	}

	public Integer getHeight() {
		return height;
	}

	@Override
	public String toString() {
		StringBuilder info = new StringBuilder("");
		for (int i = 0; i < triangle.length; i++) {
			for (int j = 0; j < triangle[i].length; j++) {
				if (triangle[i][j] != null) {
					info.append(triangle[i][j]);
				}
			}
			info.append("\n");
		}
		return info.toString();
	}

}
