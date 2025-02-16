public class ThreadTime {
    public static void main(String[] args) {
        Thread sec = new Thread(() ->{
            int i = 0;
            while(true){
                try {
                    System.out.println(i++);
                    Thread.sleep(1000);
                }catch (InterruptedException e){

                }
            }
        });
        Thread fiveSec = new Thread(()->{
            int i = 0 ;
           while(true){
               if(i % 5 == 0 && i != 0){
                   System.out.printf("Минуло %d секунд \n",i);
               }
               try {
                   Thread.sleep(1000);
                   i++;
               }catch (InterruptedException e){
                   e.printStackTrace();
               }
           }
        });
        sec.start();
        fiveSec.start();
    }
}
