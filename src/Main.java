import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        // KAMUS
        Matrix M = new Matrix(0,0);
        Scanner input = new Scanner(System.in);
        String allString[] = new String[0];
        int jmlHuruf, saveJmlHuruf;
        int i, j, k, index, baris, kolom;
        int Brs, Kol;
        boolean flag;
        long startTime, stopTime, exeTime;
        int compare;

        // ALGORITMA
        System.out.println("--------------------------------");
        System.out.println("       Word Search Puzzle       ");
        System.out.println("              With              ");
        System.out.println("      Brute Force Algorithm     ");
        System.out.println("--------------------------------");
        System.out.println("            Made By             ");
        System.out.println("      13520160 Willy Wilsen     ");
        System.out.println("--------------------------------");

        // Input file
        System.out.print("Input your Word Search Puzzle filename (.txt): ");
        String namafile = input.next();
        allString = M.bacaFileMatriks(namafile);

        // Output file
        if (allString != null) {
            System.out.println("Your file processed successfully.");
            System.out.println();
            System.out.println("--------------------------------");
            System.out.println("          Given Puzzle          ");
            System.out.println("--------------------------------");
            System.out.println();
            M.tulisMatriks();
            System.out.println();

            // Output string file
            System.out.println("--------------------------------");
            System.out.println("         Searched Words         ");
            System.out.println("--------------------------------");
            System.out.println();
            for (i=0; i<allString.length; i++) {
                System.out.print(i+1);
                System.out.print(". ");
                System.out.println(allString[i]);
            }
            System.out.println();
            System.out.println("--------------------------------");
            System.out.println("          Search Result         ");
            System.out.println("--------------------------------");

            // Proses Pencarian
            for (i=0; i<allString.length; i++) {
                System.out.println();
                System.out.print(i+1);
                System.out.print(". ");
                System.out.println(allString[i]);
                System.out.println();

                // Inisialisasi Awal
                jmlHuruf = allString[i].length();                
                flag = false;
                j = 0;
                compare = 0;
                startTime = System.nanoTime();

                // Pencocokan pada setiap indeks baris dan kolom matriks
                while (j < M.brs && !flag) {
                    k = 0;
                    while (k < M.kol && !flag) {
                        // Pencocokan huruf pertama string
                        compare++;
                        if (M.Mat[j][k] == allString[i].charAt(0)) {

                            // CEK ARAH KANAN
                            baris = j;
                            kolom = k;
                            if (!flag && M.kol - jmlHuruf - kolom >= 0) {
                                index = 1;
                                flag = true;
                                kolom++;
                                while (flag && index < jmlHuruf) {
                                    if (M.Mat[baris][kolom] != allString[i].charAt(index)) {
                                        flag = false;
                                    } else {
                                        index++;
                                        kolom++;
                                    }
                                    compare++;
                                }

                                // Jika cocok, melakukan print
                                if (flag) {
                                    for (Brs=0; Brs<M.brs; Brs++) {
                                        for (Kol=0; Kol<M.kol; Kol++) {
                                            if (Brs == j && Kol >= k && Kol < kolom) {
                                                System.out.print(M.Mat[Brs][Kol] + " ");
                                            } else {
                                                System.out.print("- ");
                                            }
                                        }
                                        System.out.println();
                                    }
                                }
                            }

                            // CEK KIRI
                            baris = j;
                            kolom = k;
                            if (!flag && kolom - jmlHuruf + 1 >= 0) {
                                index = 1;
                                flag = true;
                                kolom--;
                                while (flag && index < jmlHuruf) {
                                    if (M.Mat[baris][kolom] != allString[i].charAt(index)) {
                                        flag = false;
                                    } else {
                                        index++;
                                        kolom--;
                                    }
                                    compare++;
                                }

                                // Jika cocok, melakukan print
                                if (flag) {
                                    for (Brs=0; Brs<M.brs; Brs++) {
                                        for (Kol=0; Kol<M.kol; Kol++) {
                                            if (Brs == j && Kol <= k && Kol > kolom) {
                                                System.out.print(M.Mat[Brs][Kol] + " ");
                                            } else {
                                                System.out.print("- ");
                                            }
                                        }
                                        System.out.println();
                                    }
                                }
                            }

                            // CEK ATAS
                            baris = j;
                            kolom = k;
                            if (!flag && baris - jmlHuruf + 1 >= 0) {
                                index = 1;
                                flag = true;
                                baris--;
                                while (flag && index < jmlHuruf) {
                                    if (M.Mat[baris][kolom] != allString[i].charAt(index)) {
                                        flag = false;
                                    } else {
                                        index++;
                                        baris--;
                                    }
                                    compare++;
                                }

                                // Jika cocok, melakukan print
                                if (flag) {
                                    for (Brs=0; Brs<M.brs; Brs++) {
                                        for (Kol=0; Kol<M.kol; Kol++) {
                                            if (Brs <= j && Brs > baris  && Kol == k) {
                                                System.out.print(M.Mat[Brs][Kol] + " ");
                                            } else {
                                                System.out.print("- ");
                                            }
                                        }
                                        System.out.println();
                                    }
                                }
                            }

                            // CEK BAWAH
                            baris = j;
                            kolom = k;
                            if (!flag && M.brs - baris - jmlHuruf >= 0) {
                                index = 1;
                                flag = true;
                                baris++;
                                while (flag && index < jmlHuruf) {
                                    if (M.Mat[baris][kolom] != allString[i].charAt(index)) {
                                        flag = false;
                                    } else {
                                        index++;
                                        baris++;
                                    }
                                    compare++;
                                }

                                // Jika cocok, melakukan print
                                if (flag) {
                                    for (Brs=0; Brs<M.brs; Brs++) {
                                        for (Kol=0; Kol<M.kol; Kol++) {
                                            if (Brs < baris && Brs >= j  && Kol == k) {
                                                System.out.print(M.Mat[Brs][Kol] + " ");
                                            } else {
                                                System.out.print("- ");
                                            }
                                        }
                                        System.out.println();
                                    }
                                }
                            }

                            // CEK KANAN ATAS
                            baris = j;
                            kolom = k;
                            if (!flag && baris - jmlHuruf + 1 >= 0 && M.kol - jmlHuruf - kolom >= 0) {
                                index = 1;
                                flag = true;
                                baris--;
                                kolom++;
                                while (flag && index < jmlHuruf) {
                                    if (M.Mat[baris][kolom] != allString[i].charAt(index)) {
                                        flag = false;
                                    } else {
                                        index++;
                                        baris--;
                                        kolom++;
                                    }
                                    compare++;
                                }

                                // Jika cocok, melakukan print
                                if (flag) {
                                    baris++;
                                    kolom--;
                                    for (Brs=0; Brs<M.brs; Brs++) {
                                        if (jmlHuruf > 1 && Brs == baris+1) {
                                            baris++;
                                            kolom--;
                                            jmlHuruf--;
                                        }
                                        for (Kol=0; Kol<M.kol; Kol++) {
                                            if (Brs == baris && Kol == kolom) {
                                                System.out.print(M.Mat[Brs][Kol] + " ");
                                            } else {
                                                System.out.print("- ");
                                            }
                                        }
                                        System.out.println();
                                    }
                                }
                            }

                            // CEK KANAN BAWAH
                            baris = j;
                            kolom = k;
                            if (!flag && M.brs - baris - jmlHuruf >= 0 && M.kol - jmlHuruf - kolom >= 0) {
                                index = 1;
                                flag = true;
                                baris++;
                                kolom++;
                                while (flag && index < jmlHuruf) {
                                    if (M.Mat[baris][kolom] != allString[i].charAt(index)) {
                                        flag = false;
                                    } else {
                                        index++;
                                        baris++;
                                        kolom++;
                                    }
                                    compare++;
                                }

                                // Jika cocok, melakukan print
                                if (flag) {
                                    saveJmlHuruf = jmlHuruf;
                                    while (jmlHuruf > 0) {
                                        baris--;
                                        kolom--;
                                        jmlHuruf--;
                                    }
                                    for (Brs=0; Brs<M.brs; Brs++) {
                                        if (jmlHuruf < saveJmlHuruf-1 && Brs == baris+1) {
                                            baris++;
                                            kolom++;
                                            jmlHuruf++;
                                        }
                                        for (Kol=0; Kol<M.kol; Kol++) {
                                            if (Brs == baris && Kol == kolom) {
                                                System.out.print(M.Mat[Brs][Kol] + " ");
                                            } else {
                                                System.out.print("- ");
                                            }
                                        }
                                        System.out.println();
                                    }
                                }
                            }

                            // CEK KIRI BAWAH
                            baris = j;
                            kolom = k;
                            if (!flag && M.brs - baris - jmlHuruf >= 0 && kolom - jmlHuruf + 1 >= 0) {
                                index = 1;
                                flag = true;
                                baris++;
                                kolom--;
                                while (flag && index < jmlHuruf) {
                                    if (M.Mat[baris][kolom] != allString[i].charAt(index)) {
                                        flag = false;
                                    } else {
                                        index++;
                                        baris++;
                                        kolom--;
                                    }
                                    compare++;
                                }

                                // Jika cocok, melakukan print
                                if (flag) {
                                    saveJmlHuruf = jmlHuruf;
                                    while (jmlHuruf > 0) {
                                        baris--;
                                        kolom++;
                                        jmlHuruf--;
                                    }
                                    for (Brs=0; Brs<M.brs; Brs++) {
                                        if (jmlHuruf < saveJmlHuruf-1 && Brs == baris+1) {
                                            baris++;
                                            kolom--;
                                            jmlHuruf++;
                                        }
                                        for (Kol=0; Kol<M.kol; Kol++) {
                                            if (Brs == baris && Kol == kolom) {
                                                System.out.print(M.Mat[Brs][Kol] + " ");
                                            } else {
                                                System.out.print("- ");
                                            }
                                        }
                                        System.out.println();
                                    }
                                }
                            }

                            // CEK KIRI ATAS
                            baris = j;
                            kolom = k;
                            if (!flag && baris - jmlHuruf + 1 >= 0 && kolom - jmlHuruf + 1 >= 0) {
                                index = 1;
                                flag = true;
                                baris--;
                                kolom--;
                                while (flag && index < jmlHuruf) {
                                    if (M.Mat[baris][kolom] != allString[i].charAt(index)) {
                                        flag = false;
                                    } else {
                                        index++;
                                        baris--;
                                        kolom--;
                                    }
                                    compare++;
                                }

                                // Jika cocok, melakukan print
                                if (flag) {
                                    baris++;
                                    kolom++;
                                    for (Brs=0; Brs<M.brs; Brs++) {
                                        if (jmlHuruf > 1 && Brs == baris+1) {
                                            baris++;
                                            kolom++;
                                            jmlHuruf--;
                                        }
                                        for (Kol=0; Kol<M.kol; Kol++) {
                                            if (Brs == baris && Kol == kolom) {
                                                System.out.print(M.Mat[Brs][Kol] + " ");
                                            } else {
                                                System.out.print("- ");
                                            }
                                        }
                                        System.out.println();
                                    }
                                }
                            }
                        }
                        k++;
                    }
                    j++;
                }
                stopTime = System.nanoTime();
                exeTime = (stopTime - startTime)/1000000;
                System.out.println();
                System.out.println("Execution Time: " + exeTime + " ms.");
                System.out.println("Total Letter Comparison: " + compare + " times.");
                System.out.println();
            }
        }
    }
}