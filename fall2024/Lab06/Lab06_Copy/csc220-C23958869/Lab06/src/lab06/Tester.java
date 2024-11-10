package lab06;

public class Tester {
	public static void main(String[] args) {

    //You will need to write your own tests

    /* 
    * As a reminder these are the methods we did in lab:
    * 1.1) SortedString Constuctor
    * 1.2) SortedString compareTo(SortedString other)
    * 2) AnagramUtil areAnagrams(SortedString str1, SortedString str2)
    * 3) InsetionSort sort(E[] array) (HINT: use the toSortedString() convenience function from SortedString)
    * 4.1, 4.2, 4.3) InsertionSort  O(int n), fit(E[] array), and predict(int n)
    */
SortedString sort1 = new SortedString("cat");
SortedString sort2 = new SortedString("bat");
SortedString sort3 = new SortedString("dog");
SortedString sort4 = new SortedString("act");
SortedString sort5 = new SortedString("");
SortedString sort6 = new SortedString("catt");
System.out.println(sort1.getSorted());
System.out.println(sort1.compareTo(sort2));
System.out.println(sort1.compareTo(sort3));
System.out.println(sort1.compareTo(sort1));

System.out.println(AnagramUtil.areAnagrams(sort1, sort1)); 
System.out.println(AnagramUtil.areAnagrams(sort1, sort2)); 
System.out.println(AnagramUtil.areAnagrams(sort1, sort3)); 
System.out.println(AnagramUtil.areAnagrams(sort1, sort4)); 
System.out.println(AnagramUtil.areAnagrams(sort1, sort5)); 
System.out.println(AnagramUtil.areAnagrams(sort1, sort6)); 

String[] newString = {"cat", "dog", "bat", "fat"};


InsertionSort<String> obj1 = new InsertionSort<String>();
String[] anotherOne = obj1.sort(newString);

for(int i = 0; i < newString.length; i++) {
	System.out.print(anotherOne[i] + " ");
}

obj1.fit(newString);
System.out.println();
System.out.println(obj1.predict(newString.length));
System.out.println(obj1.predict(100000000));


    /* 
    * As a reminder these are the methods we did in assignment:
    * 1) AnagramUtil getLargestAnagramGroup(SortedString[] stringList) (Hint: You can use getLargestAnagramGroup(String filename))
    * 2) MergeSort sort(E[] array1, E[] array2, int first, int last) (Hint: You can use sort(E[] array))
    * 3.1, 3.2, 3.3) MergeSort  O(int n), fit(E[] array), and predict(int n)
    */

String[] s3 = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
for(int i = 0; i < s3.length; i++) {
	System.out.print(s3[i] + " ");
}

MergeSort<String> obj2 = new MergeSort<String>();
String[] merge = obj2.sort(newString);

System.out.println(" ");

for(int i = 0; i < newString.length; i++) {
	System.out.print(merge[i] + " ");
}

obj2.fit(newString);
System.out.println("");
System.out.println(obj2.predict(newString.length));
System.out.println(obj2.predict(100000000));
	}
}

