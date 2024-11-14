package lab06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class CheckLab {
    public static String FILE_DIR = "/Users/CristobalLillo_1/TA/csc220-scripts_Automated_Grading_fromJerry/csc220-scripts/java/";
    
    public static boolean ListsEqual(String[] list1, String[] list2) {
        if (list1.length != list2.length)
            return false;
        if (list1 == null || list1.length == 0)
            return true;
            
        // Convert to SortedString arrays and sort them
        SortedString[] sorted1 = SortedString.toSortedString(list1);
        SortedString[] sorted2 = SortedString.toSortedString(list2);
        
        // Use your MergeSort implementation to sort the arrays
        MergeSort<SortedString> sorter = new MergeSort<>();
        sorted1 = sorter.sort(sorted1);
        sorted2 = sorter.sort(sorted2);
        
        // Compare the sorted strings
        for (int i = 0; i < sorted1.length; i++) {
            if (sorted1[i].compareTo(sorted2[i]) != 0)
                return false;
        }
        
        return true;
    }
    
    public static void printList(String[] list) {
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        // they get up to 35% for submission, compile, run
        
        //*************************** sort is worth 10% *********************************************
        int[] gradePoint = {0,0,0,0,0};
        int[] givenPoint = {10,10,15,15,15};
        String output = "";
        
        try {
            // Test SortedString functionality instead of direct string sorting
            try {
                SortedString test1 = new SortedString("joy");
                if (!test1.getSorted().equals("joy"))
                    output += "TEST FAILED -- sort -- for already sorted strings\n";
                else
                    gradePoint[0] += 50;
            } catch (Exception e) {
                output += "sort(joy) threw " + e + "\n";
            }

            try {
                SortedString test2 = new SortedString("Anagram");
                if (!test2.getSorted().equals("aaagmnr"))
                    output += "TEST FAILED -- sort\n";
                else
                    gradePoint[0] += 50;
            } catch (Exception e) {
                output += "sort(anagram) threw " + e + "\n";
            }

            //********************************** areAnagrams is worth 10% **************************************
            try {
                if (!AnagramUtil.areAnagrams(new SortedString(""), new SortedString("")))
                    output += "TEST FAILED -- areAnagrams -- both null strings\n";
                else
                    gradePoint[1] += 100 * 1.0 / 6.0;
            } catch (Exception e) {
                output += "## areAnagrams(\"\", \"\") threw " + e + "\n";
            }

            // Continue with remaining tests...
            // [Previous tests converted to use SortedString]

            try {
                if (!AnagramUtil.areAnagrams(new SortedString(""), new SortedString("Anagram")))
                    gradePoint[1] += 100 * 1.0 / 6.0;
            } catch (Exception e) {
                output += "## areAnagrams(\"\", Anagram) threw " + e + "\n";
            }

            // ... [rest of the tests following the same pattern]

            // For getLargestAnagramGroup tests, use the existing implementation
            // as it already works with your AnagramUtil implementation

            try {
                String[] no_anagram1 = AnagramUtil.getLargestAnagramGroup(FILE_DIR + "no_anagrams.txt");
                if (no_anagram1.length != 0)
                    output += "TEST FAILED -- getLargestAnagramGroup(file) -- list with no anagrams \n";
                else
                    gradePoint[3] += 100 * 1.0 / 5.0;
            } catch (Exception e) {
                output += "## getLargestAnagramGroup(file) threw " + e + "\n";
            }

            // ... [remaining tests]

        } catch (Exception ex) {
            output += "program threw " + ex + "\n";
        }

        arrayTestPrint(gradePoint, givenPoint);
        System.out.println(output);
    }
    
    public static void arrayTestPrint(int[] arr, int[] givenpoint) {
        System.out.print("$$");
        int i = 0;
        for (int r : arr) {
            System.out.print(Math.round((r * givenpoint[i]) / 100.0));
            System.out.print("$$");
            i++;
        }
    }

    public static String[] readFile(String filename) {
        ArrayList<String> results = new ArrayList<String>();
        try {
            BufferedReader input = new BufferedReader(new FileReader(filename));
            while (input.ready()) {
                results.add(input.readLine());
            }
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] retval = new String[1];
        return results.toArray(retval);
    }
}