package aarnav100.developer.bankapp;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        if(hasFocus){
                final ImageView im=(ImageView)findViewById(R.id.pointer);
            Animation slide =AnimationUtils.loadAnimation(Suggestion.this,R.anim.slide);
            slide.setDuration(5000);
            slide.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    TextView tv=(TextView)findViewById(R.id.status);
                    tv.setText("Home Loan Score : 85%");
                    ((LinearLayout)findViewById(R.id.end)).setVisibility(View.VISIBLE);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            im.startAnimation(slide);
        }
    }
}
