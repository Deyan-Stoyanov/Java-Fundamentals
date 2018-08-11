import P01_ExtendedArrayList.ExtendedArrayList;
import P02_FileStream.File;
import P02_FileStream.Music;
import P02_FileStream.StreamProgressInfo;
import P03_GraphicEditor.Circle;
import P03_GraphicEditor.GraphicEditor;
import P03_GraphicEditor.Rectangle;
import P04_DetailPrinter.DetailsPrinter;
import P04_DetailPrinter.Employee;
import P04_DetailPrinter.Manager;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        usingExtendedArrayList();
//        usingFileStream();
//        usingGraphicEditor();
//        usingDetailsPrinter();

    }

    private static void usingDetailsPrinter() {
        List<Employee> employees = new ArrayList<>(){{
           add(new Employee("Pesho"));
           add(new Manager("Pesho", new ArrayList<>()));
        }};
        DetailsPrinter printer = new DetailsPrinter(employees);
        printer.printDetails();
    }

    private static void usingGraphicEditor() {
        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.drawShape(new Circle());
        graphicEditor.drawShape(new Rectangle());
    }

    private static void usingFileStream() {
        StreamProgressInfo streamProgressInfo = new StreamProgressInfo(new Music(100, 20));
        System.out.println(streamProgressInfo.calculateCurrentPercent());
        streamProgressInfo = new StreamProgressInfo(new File(175, 15));
        System.out.println(streamProgressInfo.calculateCurrentPercent());
    }

    private static void usingExtendedArrayList() {
        List<Integer> myList = new ExtendedArrayList<>();
        for (int i = 0; i < 9; i++) {
            myList.add(i);
        }
        System.out.println(((ExtendedArrayList<Integer>) myList).max());
        System.out.println(((ExtendedArrayList<Integer>) myList).min());
    }
}
