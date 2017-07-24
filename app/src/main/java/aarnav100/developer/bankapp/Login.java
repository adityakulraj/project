package aarnav100.developer.bankapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    private EditText name,mail,pass;
    private Button login,regitser;
    private View.OnClickListener ocl;
    private FirebaseAuth mAuth;
    public static final String TAG="tag";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        name=(EditText)findViewById(R.id.name);
        mail=(EditText)findViewById(R.id.email);
        pass=(EditText)findViewById(R.id.pass);
        login=(Button)findViewById(R.id.signin);
        regitser=(Button)findViewById(R.id.register);
        ocl=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId())
                {
                    case R.id.signin:
                        mAuth.signInWithEmailAndPassword(mail.getText().toString(), pass.getText().toString())
                                .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        Log.d(TAG, "signInWithEmail:onComplete:" + task.isSuccessful());

                                        // If sign in fails, display a message to the user. If sign in succeeds
                                        // the auth state listener will be notified and logic to handle the
                                        // signed in user can be handled in the listener.
                                        if (!task.isSuccessful()) {
                                            Toast.makeText(Login.this,"Please try again",
                                                    Toast.LENGTH_SHORT).show();
                                        }
                                        else
                                            startActivity(new Intent(Login.this,MainActivity.class));
                                        // ...
                                    }
                                });
                        break;
                    case R.id.register:
                        mAuth.createUserWithEmailAndPassword(mail.getText().toString(), pass.getText().toString())
                                .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                                        // If sign in fails, display a message to the user. If sign in succeeds
                                        // the auth state listener will be notified and logic to handle the
                                        // signed in user can be handled in the listener.
                                        if (!task.isSuccessful()) {
                                            Toast.makeText(Login.this, "Registeration Unsuccessful", Toast.LENGTH_SHORT).show();
                                        }
                                        else
                                            Toast.makeText(Login.this, "Login with id and password", Toast.LENGTH_SHORT).show();
                                    }
                                });
                        break;
                }
            }
        };
    }
}
