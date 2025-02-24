// メインクラス
public class MultithreadingExample {
    public static void main(String[] args) {
        // スレッド1を作成し、"Thread-1"という名前を付ける
        Thread thread1 = new Thread(new Counter("Thread-1"));
        // スレッド2を作成し、"Thread-2"という名前を付ける
        Thread thread2 = new Thread(new Counter("Thread-2"));
        // スレッド3を作成し、"Thread-3"という名前を付ける
        Thread thread3 = new Thread(new Counter("Thread-3"));
        // スレッド4を作成し、"Thread-4"という名前を付ける
        Thread thread4 = new Thread(new Counter("Thread-4"));
        // スレッド5を作成し、"Thread-5"という名前を付ける
        Thread thread5 = new Thread(new Counter("Thread-5"));

        // スレッドを開始する
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}


// カウンタークラスはRunnableインターフェースを実装
class Counter implements Runnable {
    private String threadName;

    // コンストラクタでスレッドの名前を設定
    public Counter(String threadName) {
        this.threadName = threadName;
    }

    // runメソッドをオーバーライドしてスレッドの処理を定義
    @Override
    public void run() {
        // 1から50までカウントするループ
        for (int i = 1; i <= 50; i++) {
            // スレッドの名前とカウントを出力
            System.out.println(threadName + ": " + i);
            try {
                // 文字列結合を行う処理
                String result = "";
                for (int j = 0; j < 1000; j++) {
                    result += threadName + " - " + i + " - " + j + " ";
                }
                // 結果の長さを出力
                System.out.println(threadName + " result length: " + result.length());

                // スレッドを1秒間一時停止
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // スレッドが中断された場合の処理
                System.out.println(threadName + " interrupted.");
            }
        }
        // カウントが終了したことを出力
        System.out.println(threadName + " finished.");
    }
}
