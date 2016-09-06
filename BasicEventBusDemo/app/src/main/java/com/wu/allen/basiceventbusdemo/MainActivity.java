package com.wu.allen.basiceventbusdemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MianActivity";
    Button btn;
    TextView tv,tv1,tv2,tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * 这时候订阅者执行的线程与事件的发布者所在的线程为同一个线程。
     * 也就是说事件由哪个线程发布的，订阅者就在哪个线程中执行。
     * 这个也是EventBus默认的线程模式，也就是说在上面的例子中用的就是这种ThreadMode。
     * 由于没有线程的切换，也就意味消耗的资源也是最小的。如果一个任务不需要多线程的，
     * 也是推荐使用这种ThreadMode的。
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.POSTING)
    public void onPostingModeMessage(MessageEvent event){
        //tv.setText(getResultString("ThreadMode:POSTING",event.message));
        Log.d(TAG, getResultString("ThreadMode:POSTING",event.message));
    }

    /**
     * 主线程中运行的，不能进行耗时任务
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMainModeMessage(MessageEvent event){
        //tv1.setText(getResultString("ThreadMode:MAIN",event.message));
        Log.d(TAG, getResultString("ThreadMode:MAIN",event.message));
    }

    /**
     * 订阅者在后台线程中执行
     * 如果发布者是在主线程中进行的事件发布，那么订阅者将会重新开启一个子线程运行，
     * 若是发布者在不是在主线程中进行的事件发布，那么这时候订阅者就在发布者所在的线程中执行任务。
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onBackgroundModeMessage(MessageEvent event){
        //tv2.setText(getResultString("ThreadMode:BACKGROUND",event.message));
        Log.d(TAG, getResultString("ThreadMode:BACKGROUND",event.message));
    }

    /**
     * 在这种模式下，订阅者将会独立运行在一个线程中。
     * 不管发布者是在主线程还是在子线程中进行事件的发布，订阅者都是在重新开启一个线程来执行任务
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void onAsyncModeMessage(MessageEvent event){
        //tv.setText(getResultString("ThreadMode:ASYNC",event.message));
        Log.d(TAG, getResultString("ThreadMode:ASYNC",event.message));
    }

    private String getResultString(String threadMode,String msg){
        StringBuilder sb = new StringBuilder("");
        sb.append(threadMode)
            .append("\n接收到的消息：")
            .append(msg)
            .append("\n线程id:")
            .append(Thread.currentThread().getId())
            .append("\n是否是主线程：")
            .append(Looper.getMainLooper() == Looper.myLooper())
            .append("\n");
        return sb.toString();
    }

    // 测试优先级相关 优先级
    // 数字越大优先级越高
    @Subscribe(priority = 1)
    public void onPriority1Message(MessageEvent event){

        Log.d(TAG, "priority = 1:" + event.message);
    }

    @Subscribe(priority = 2)
    public void onPriority2Message(MessageEvent event){

        Log.d(TAG, "priority = 2:" + event.message);
        EventBus.getDefault().cancelEventDelivery(event) ;
    }

    @Subscribe(priority = 4)
    public void onPriority4Message(MessageEvent event){

        Log.d(TAG, "priority = 4:" + event.message);
    }

    @Subscribe(priority = 3)
    public void onPriority3Message(MessageEvent event){

        Log.d(TAG, "priority = 3:" + event.message);

    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }
}
