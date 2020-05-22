//package com.example.rentit;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Context;
//import android.content.Intent;
//import android.content.SharedPreferences;
//import android.net.Uri;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.Button;
//import android.widget.Toast;
//
//import com.google.android.gms.auth.api.signin.GoogleSignIn;
//import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
//import com.google.android.gms.auth.api.signin.GoogleSignInClient;
//import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
//import com.google.android.gms.common.api.ApiException;
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.android.material.navigation.NavigationView;
//import com.google.firebase.auth.AuthCredential;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.auth.GoogleAuthProvider;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//
//public class LoginActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
//    private Button signInButton;
//    private static GoogleSignInClient mGoogleSignInClient;
//    private String TAG = "LoginActivity";
//    private FirebaseAuth mAuth;
//    private MenuItem btnSignOut;
//    private boolean logoutVisible = false;
//    private boolean loginVisible = false;
//    private int RC_SIGN_IN = 1;
//    SharedPreferences sharedPref;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//
//        signInButton = findViewById(R.id.google_signin);
//        mAuth = FirebaseAuth.getInstance();
//        btnSignOut = findViewById(R.id.logout);
//
//        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestIdToken(getString(R.string.default_web_client_id))
//                .requestEmail()
//                .build();
//
//        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
//
//        signInButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                signIn();
//            }
//        });
//
//        sharedPref = this.getSharedPreferences("com.example.rentit", Context.MODE_PRIVATE);
//
//
//    }
//    @Override
//    public boolean onPrepareOptionsMenu(Menu menu) {
//        menu.findItem(R.id.login).setVisible(loginVisible);
//        menu.findItem(R.id.logout).setVisible(logoutVisible);
//        return super.onPrepareOptionsMenu(menu);
//    }
//
//    private void signIn(){
//        loginVisible = false;
//        logoutVisible = true;
//        invalidateOptionsMenu();
//        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
//        startActivityForResult(signInIntent, RC_SIGN_IN);
//    }
//
//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//        if (menuItem.getItemId() == R.id.logout){
//            mGoogleSignInClient.signOut();
//            Toast.makeText(LoginActivity.this,"You are Logged Out",Toast.LENGTH_SHORT).show();
//            loginVisible = true;
//            logoutVisible = false;
//            invalidateOptionsMenu();
//
//
//
//        }
//
//        return true;
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if(requestCode == RC_SIGN_IN){
//            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
//            handleSignInResult(task);
//        }
//    }
//
//    private void handleSignInResult(Task<GoogleSignInAccount> completedTask){
//        try{
//
//            GoogleSignInAccount acc = completedTask.getResult(ApiException.class);
//            Toast.makeText(LoginActivity.this,"Signed In Successfully",Toast.LENGTH_SHORT).show();
//            FirebaseGoogleAuth(acc);
//
//
//        }
//        catch (ApiException e){
//            Log.i(TAG, e.getMessage());
//            Toast.makeText(LoginActivity.this,"Sign In Failed",Toast.LENGTH_SHORT).show();
//            FirebaseGoogleAuth(null);
//        }
//    }
//
//    private void FirebaseGoogleAuth(GoogleSignInAccount acct) {
//        //check if the account is null
//        if (acct != null) {
//            AuthCredential authCredential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
//            mAuth.signInWithCredential(authCredential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                @Override
//                public void onComplete(@NonNull Task<AuthResult> task) {
//                    if (task.isSuccessful()) {
//                        Toast.makeText(LoginActivity.this, "Successful", Toast.LENGTH_SHORT).show();
//                        FirebaseUser user = mAuth.getCurrentUser();
//                        updateUI(user);
//                    } else {
//                        Toast.makeText(LoginActivity.this, "Failed", Toast.LENGTH_SHORT).show();
//                        updateUI(null);
//                    }
//                }
//            });
//        }
//        else{
//            Toast.makeText(LoginActivity.this, "acc failed", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//
//
//    private void updateUI(FirebaseUser fUser){
//        final DatabaseReference RootRef;
//        RootRef = FirebaseDatabase.getInstance().getReference();
//
//
//        logoutVisible = true;
//        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getApplicationContext());
//        if(account !=  null){
//            String personName = account.getDisplayName();;
//            String personEmail = account.getEmail();
//            String personId = account.getId();
//            Uri personPhoto = account.getPhotoUrl();
//
//            Toast.makeText(LoginActivity.this,personName + personEmail ,Toast.LENGTH_SHORT).show();
//
//            sharedPref.edit().putBoolean("IsUserLogined", true).apply();
//            Intent intent = new Intent(this, HomeActivity.class);
//                this.startActivity(intent);
//        }
//
//    }
//
//
//
////            SharedPreferences.Editor editor = sharedPref.edit();
////            editor.putBoolean("IsUserLogined"), false);
////            editor.apply();
//}
//
//
//
//
//
//
//
//
//
//
