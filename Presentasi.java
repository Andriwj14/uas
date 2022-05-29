import java.util.LinkedList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Presentasi {
    private static LinkedList<String> dataStorage = new LinkedList<String>();

	private static Scanner extracted() {
		return new Scanner(System.in);
	}

	private static void displayData(){
		System.out.println("\nDaftar Antrian    : " + dataStorage);
		System.out.println("Jumlah Antrian    : " + dataStorage.size());
	}

	private static void inputData() {
		System.out.print("Masukkan Data: ");
		String tempData = extracted().nextLine();
		dataStorage.add(tempData);
		displayData();
	}

	private static void inputDataAwal() {
		System.out.print("Masukkan Data: ");
		String tempData = extracted().nextLine();
		dataStorage.addFirst(tempData);
		displayData();
	}

	private static void inputDataAkhir() {
		System.out.print("Masukkan Data: ");
		String tempData = extracted().nextLine();
		dataStorage.addLast(tempData);
		displayData();
	}

	private static void inputDataManual() {
		boolean status = true;
		int indexData = 0;
		displayData();
		while(status) {
			System.out.print("Pilih Index Data yang ingin disisipi data: [0-" + (dataStorage.size() - 1) + "]: ");
			try {
				status = false;
				indexData = extracted().nextInt();
			}
			catch(InputMismatchException e) {
				System.out.println("Data harus berupa Angka!");
				status = true;
			}
		}
		System.out.print("Data yang ingin disisipkan pada index data ke- " + indexData + ": ");
		String tempData = extracted().nextLine();
		dataStorage.add(indexData, tempData);
		displayData();
	}

	private static boolean searchData(String data) {
		return dataStorage.contains(data);
	}

	private static void hapusData() {
		boolean status = true;
		int indexData = 0;
		displayData();
		while(status) {
			System.out.print("Pilih Index Data yang ingin dihapus: [0-" + (dataStorage.size() - 1) + "]: ");
			try {
				status = false;
				indexData = extracted().nextInt();
			}
			catch(InputMismatchException e) {
				System.out.println("Data harus berupa Angka!");
				status = true;
			}
		}
		dataStorage.remove(indexData);
		displayData();
	}

	private static void hapusDataAwal() {
		dataStorage.removeFirst();
		displayData();
	}

	private static void hapusDataAkhir() {
		dataStorage.removeLast();
		displayData();
	}

	private static void keluar() {
		System.exit(0);
	}

	private static void deskripsiProgram() {
		System.out.println("\nSingle Linked List Program"
                                    + "\nProgram ini dibuat oleh :"
                                    + "\n362155401214   Dhava Bagus Saputra 1G"
                                    + "\n362155401206   Andri Wijaksono     1G"
				         );
	}

	private static void programSwitcher() {
		boolean status = true;
		int indexMenu = 0;
		while(status) {
			try {
				status = false;
				System.out.print("Pilih Menu [1~9]: ");
				indexMenu = extracted().nextInt();
			}
			catch(InputMismatchException e) {
				System.out.println("Masukan harus berupa Angka!");
				status = true;
			}
		}

		switch(indexMenu) {
			case 1: inputData(); break;
			case 2: inputDataAwal(); break;
			case 3: inputDataAkhir(); break;
			case 4: inputDataManual(); break;
			case 5: hapusData(); break;
			case 6: hapusDataAwal(); break;
			case 7: hapusDataAkhir(); break;
			case 8: deskripsiProgram(); break;
			case 9: keluar(); break;
		}
		programMenu();
	}

	private static void programMenu() {
		System.out.println("\n.: PROGRAM MENU :."
				         + "\n 1. Tambahkan Data"
				         + "\n 2. Tambahkan Data Awal"
				         + "\n 3. Tambahkan Data Akhir"
				         + "\n 4. Tambahkan Data Manual"
				         + "\n 5. Hapus Data Manual"
				         + "\n 6. Hapus Data Awal"
				         + "\n 7. Hapus Data Akhir"
				         + "\n 8. Deskripsi Program"
				         + "\n 9. Keluar Program");
		programSwitcher();
	}

	public static void main(String[] args) {
		deskripsiProgram();
		programMenu();
	}
}