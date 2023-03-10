public class implem {


    public static void main(String[] args) {


        Markov mr = new Markov();
        mr.addFromFile("/Users/zainabzoya/Documents/Java File/Markov/src/test.txt");


        System.out.println(mr );


        for(int i = 0 ; i < 5 ; i++){
        System.out.println(mr.getSentence() + " ");
        }



    }
}
