import java.util.Scanner;
import java.io.*;

public class Matrix {
    // Atribut
	public char[][] Mat;
	protected int brs, kol;

	/* CONSTRUCTOR */
	public Matrix(int i, int j) {
		this.brs = i;
		this.kol = j;		
		Mat = new char[i][j];
		for (i = 0; i < this.brs; i++) {
			for (j = 0; j < this.kol; j++) {
				Mat[i][j] = 'A';
			}
		}
	}

    public String[] bacaFileMatriks (String FileName) {
		// Membaca file eksternal kemudian dikonversi kedalam tipe Matrix dan mengeluarkan array of string
		try {
			String dir = "../../test/" + FileName;
			File file = new File(dir);
			int i,j;
			int Nbrs = 0 , Nkol = 0, numBrs = 0;

			// Menghitung total baris pada txt
			Scanner input = new Scanner(file);
			while(input.hasNextLine()) {
				numBrs++;
				input.nextLine();
			}
			input.close();

			// Menghitung jumlah kolom matriks
			input = new Scanner(file);
			Scanner huruf = new Scanner(input.nextLine());
			while (huruf.hasNext()){
				Nkol++;
				huruf.next();
			}
			huruf.close();
			input.close();

			// Menghitung jumlah baris matriks
			input = new Scanner(file);
			while ((input.next()).length() == 1) {
				Nbrs++;
			}
			input.close();
			Nbrs = Nbrs/Nkol;

			// Re-assign ukuran matriks
			this.brs = Nbrs;
			this.kol = Nkol;
			Mat = new char[Nbrs][Nkol];

			// Pengisian nilai matrix
			input = new Scanner(file);
			for (i=0; i<Nbrs;i++){
				for (j=0; j < Nkol; j++){
					this.Mat[i][j] = input.next().charAt(0);
				}
			}

			// Pengisian nilai array of string
			int jmlString = numBrs - Nbrs - 1;
			String allString[] = new String[jmlString];
			for (i=0; i<jmlString; i++) {
				allString[i] = input.next();
			}
			input.close();

			// Mengembalikan array
			return allString;
		// Jika tidak menemukan file
		} catch (FileNotFoundException e) {
			System.out.println("File not found. Check your filename again.");
			return null;
		}
	}	

	void tulisMatriks() {
		// Mencetak elemen matriks berukuran M x N ke layar
		int i, j;

		for (i = 0; i < this.brs; i++) {
			for (j = 0; j < this.kol; j++) {
				System.out.print(this.Mat[i][j] + " ");
			}
			System.out.println();
		}
	}
}