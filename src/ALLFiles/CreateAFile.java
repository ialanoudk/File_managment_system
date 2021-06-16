package ALLFiles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CreateAFile {

	public static void main(String[] args) {
		System.out.println(
				"\t\t\t\nMy name : Al-anoud Bo-dokhi. \nI train the Ministry of Communications and Information Technology.  \nThis First Project For Phase_1\n ");
		int choice, choice2;
		String path = "";
		Scanner in = new Scanner(System.in);
		Scanner input = new Scanner(System.in);
		do {
			System.out.println(
					"\t\t\t\t************************************Welcome to Files Managment System!*************************************\n");
			System.out.println("\nPlease Choose From the Menue What You Want to Do With Your Files .\n");
			System.out.println("[1] List ALL Files.");
			System.out.println("[2] Manage Files option. ");
			System.out.println("[3] Exit.");
			System.out.print("Choice: ");
			choice = in.nextInt();
			switch (choice) {
			case 1: // List ALL Files
				System.out.println(
						"\t\t\t*****************************List ALL Files option******************************");
				System.out.println("[1]ALL Listed Files In Existing Directory.");
				System.out.println("[2]Exit...Back to main menu!");
				System.out.print("Choice: ");
				choice2 = in.nextInt();
				switch (choice2) {
				case 1:
					System.out.println("\t\t\tENTER THE FILE NAME WITH PATH TO LIST ALL FILES IN THIS DIRECTORY. \n");
					String folderpath = input.nextLine();
					File folder = new File(folderpath);
					File[] files = folder.listFiles();

					if (folder.isDirectory()) {
						if (folder.list().length > 0) {
							System.out.println("\nThe directory " + folder.getPath() + " is not empty\n");
						} else {
							System.out.println("\nThe directory " + folder.getPath() + " is empty\n");
						}}
					// Iterate the files array
					for (File file : files) {
						// check if the file
						if (file.isFile()) {
							System.out.println("File : " + file.getName());
						} else {
							if (file.isDirectory()) {
								System.out.println("Folder : " + file.getName());
							}
						}
					}
					System.out.println("\nThe Return of Current File names in Directory.\n ");
					break;
				case 2:
					System.out.println("\t\tBack to main menu.....!\n");
					break;
				}
				break;
			case 2: // Manage Files option.

				System.out.println(
						"\t\t\t*****************************Manage  Files option******************************");
				System.out.println("[1] Create File.");
				System.out.println("[2] Write to a File.");
				System.out.println("[3] Read from a File.");
				System.out.println("[4] Search for File.");
				System.out.println("[5] Delete a File");
				System.out.println("[6] Exit");
				System.out.print("Choice: ");
				choice2 = in.nextInt();
				switch (choice2) {
				case 1:
					// Create or Add new file with entered path
					System.out.println("\t\t\tENTER THE PATH WITH THE FILE NAME YOU WANT TO CREATE THE FILE TO. \n");
					String filename = input.nextLine();
					// String directory =System.getProperty("user.home");
					path = File.separator + filename;
					File myFile = new File(path);
					myFile.getParentFile().mkdirs();
					try {
						if (myFile.createNewFile()) {
							System.out.print("\nFile Created Successfully.\n");
						} else {
							System.out.print("\nFile Created Unsuccessfully.\n");
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.print("\nError......Failed to Create The File.\n");
					}
					break;
				case 2:

					// Write to File
					System.out.println("\t\t\tENTER THE PATH WITH FILE NAME YOU WANT TO WRITE THE DATA TO . \n");
					filename = input.nextLine();
					System.out.println("\t\t\tWRITE DATA TO FILE.\n ");
					String data = input.nextLine();
					try {
						FileWriter output = new FileWriter(filename);
						BufferedWriter br = new BufferedWriter(output);
						output.write(data);
						System.out.print("\nData Written Successfully to The File.\n");
						System.out.print("\n");
						output.close();
						br.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.print("\nError.... to Write The Data.\n");
						System.out.print("\n");
					}
					break;
				case 3:
					// Read or Retrieve data from file
					System.out.println("\t\t\tENTER THE PATH WITH THE FILE NAME YOU WANT TO READ. \n");
					filename = input.nextLine();
					try {
						FileReader readData = new FileReader(filename);
						BufferedReader br = new BufferedReader(readData);
						String line;
						while ((line = br.readLine()) != null) {
							System.out.print(line);
						}
						System.out.print("\n");
						System.out.println("\nData Retrieved from file successfully.\n");
						System.out.print("\n");
						readData.close();
						br.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println("\nError...File to Read Data.\n");
					}
					break;
				case 4:
					// Search the file

					System.out.print("\t\t\tENTER THE PATH DIRECTORY TO SEARCH.\n");
					String ser = input.nextLine();
					path = File.separator + ser;
					File fs = new File(path);
					File[] files = fs.listFiles();
					for (File f : files) {
						if (f.isFile()) {
							System.out.println("\nSearch File " + f.getName()+" Done successfully");
						} else {
							if (f.isDirectory()) {
								System.out.println("\nSearch Folder " + f.getPath()+" Done Successfully");
							}
						}
					}
					//System.out.println("\nSearch Done Successfully.\n");
					break;
				case 5:
					// Delete file from directory
					System.out.println("\t\t\tENTER THE PATH OR THE FILE NAME TO BE DELETED.\n");
					filename = input.nextLine();
					path = File.separator + filename;
					File fpath = new File(path);
					if (fpath.delete()) {
						System.out.println("\nFile : " + fpath.getName() + " Deleted Successfully.\n");
					} else {
						System.out.println("\nFailed to Delete a File.\n");
					}
					break;
				case 6:
					System.out.println("\nBack to main menu!\n");
					break;
				}

				break;
			case 3:
				System.out.println("\nExiting the system!\n");
				break;
			}
		} while (choice != 3);
	}// End Main
}
