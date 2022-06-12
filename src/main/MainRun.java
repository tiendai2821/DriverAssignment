package main;

import entity.Assignment;
import entity.Driver;
import entity.Route;
import service.AssignmentService;
import service.DriverService;
import service.RouteService;
import util.DataUtil;
import util.file.FileUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainRun {

    public static List<Driver> driverList;
    public static List<Route> routeList;
    public static List<Assignment> assignmentList;
    public static String diverFile = "driver.dat";
    public static String routeFile = "route.dat";
    public static String assignmentFile = "assignment.dat";
    public static DriverService driverService = new DriverService();
    public static RouteService routeService = new RouteService();
    public static AssignmentService assignmentService = new AssignmentService();
    public static void main(String[] args) {


        initData();
        Menu();
    }

    private static void initData() {
        FileUtil fileUtil = new FileUtil();
        Object driverFromFile = fileUtil.readDataFromFile(diverFile);
        driverList = DataUtil.isNullOrEmpty(driverFromFile) ? new ArrayList<>() : (List<Driver>) driverFromFile;
        Object routeFromFile = fileUtil.readDataFromFile(routeFile);
        routeList = DataUtil.isNullOrEmpty(routeFromFile)? new ArrayList<>(): (List<Route>) routeFromFile;
        Object assignmentFromFile = fileUtil.readDataFromFile(assignmentFile);
        assignmentList  = DataUtil.isNullOrEmpty(assignmentFromFile)? new ArrayList<>():(List<Assignment>) assignmentFromFile;

    }

    private static void Menu() {
        while (true) {
            int function = -1;
            try {

                while (true) {
                    System.out.println("\n\n-------Phần mềm quản lý phân công lái xe-------\n\n");
                    System.out.println("1.Nhập lái xe mới và in ra danh sách lái xe");
                    System.out.println("2.Nhập tuyến mới và in ra danh sách tuyến");
                    System.out.println("3.Nhập và in ra danh sách phân công cho mỗi lái xe");
                    System.out.println("4.Sắp xếp danh sách phân công theo họ tên lái xe");
                    System.out.println("5.Sắp xếp danh sách phân công theo số lượng tuyến");
                    System.out.println("6.Thống kê tổng khoảng cách chạy xe trong ngày của mỗi lái xe");
                    System.out.println("7.Thoát chương trình");
                    function = Integer.parseInt(new Scanner(System.in).next());
                    if (function <= 7 && function >= 1) {
                        break;
                    }
                    System.out.println("Chỉ nhập từ 1 đến 7, mời nhập lại");
                }


            } catch (NumberFormatException e) {
                System.out.println("Đầu vào là 1 số, mời nhập lại: ");
            }
            switch (function){
                case 1:
                    driverService.addDriver();
                    driverService.showDriverTable();
                    break;
                case 2:
                    routeService.addRoute();
                    routeService.showRouteTable();
                    break;
                case 3:
                    assignmentService.addAssignment();
                    assignmentService.showAssignment();
                    break;
                case 4:
                    assignmentService.sortByName();
                    assignmentService.showAssignment();
                    break;
                case 5:
                    assignmentService.sortByQuantity();
                    assignmentService.showAssignment();
                    break;
                case 6:
                    assignmentService.staticsByDistance();
                    break;
                case 7:
                    System.out.println("Tks for use our system!!!");
                    return;
            }
        }
    }

}