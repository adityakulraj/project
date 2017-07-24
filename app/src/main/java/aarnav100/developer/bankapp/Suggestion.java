package aarnav100.developer.bankapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Suggestion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestion);
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        database.getReference("Customer/First_Customer").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //dataSnapshot.getValue();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("TAG",databaseError.toString());
            }
        });
        work();
    }
    void work()
    {
//        Thread r=new Thread() {
//            @Override
//            public void run() {
//                long t=System.currentTimeMillis();
//                ImageView im=(ImageView)findViewById(R.id.pointer);
//                while(System.currentTimeMillis()-t<5000) {
//                    ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) im.getLayoutParams();
//                    params.leftMargin = 10 + (int)System.currentTimeMillis()/100;
//                }
//
//                TextView tv=(TextView)findViewById(R.id.status);
//                tv.setText("Home Loan Score : 85%");
//                ((LinearLayout)findViewById(R.id.end)).setVisibility(View.VISIBLE);
//            }
//        };
//        r.run();
    }
}
