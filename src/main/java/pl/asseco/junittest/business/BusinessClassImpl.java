package pl.asseco.junittest.business;

import pl.asseco.junittest.data.DataService;

import java.util.Arrays;

public class    BusinessClassImpl {

    private DataService dataService;

    public void setDataService(DataService dataService) {
        this.dataService = dataService;
    }

    public int sumValues(int ... data) {
            return Arrays.stream(data).sum();
    }

    public int calculateWithDataService() {
        int[] data = dataService.retrieveAll();
        return Arrays.stream(data).sum();
    }

    public static String getName() {
        return "ALA";
    }


}
