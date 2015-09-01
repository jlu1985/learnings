package jlu.nio;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

// Class to illustrate how to user Pth interface and its methods
public class PathInfo1 {
	public static void main(String[] args) {
		// create a Path object by calling static method get() in Paths class
//		Path testFilePath = Paths.get("D:\\test\\testfile.txt");
//		Path testFilePath = Paths.get("/home/test/testfile.txt");
		Path testFilePath = FileSystems.getDefault().getPath("/home/test/testfile.txt");
		// retrieve basic infomation about path
		System.out.println("Printing file information: ");
		System.out.println("\t file name: " + testFilePath.getFileName());
		System.out.println("\t root of the path: " + testFilePath.getRoot());
		System.out.println("\t parent of the target: "
				+ testFilePath.getParent());

		// print path elements
		System.out.println("Printing elements of the path: ");
		for (Path element : testFilePath) {
			System.out.println("\t path element: " + element);
		}
	}

}
