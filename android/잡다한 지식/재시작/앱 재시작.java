Intent mStartActivity = new Intent(HomeActivity.this, SplashScreen.class);
int mPendingIntentId = 123456;
PendingIntent mPendingIntent = PendingIntent.getActivity(HomeActivity.this, mPendingIntentId, mStartActivity,
PendingIntent.FLAG_CANCEL_CURRENT);
AlarmManager mgr = (AlarmManager) HomeActivity.this.getSystemService(Context.ALARM_SERVICE);
mgr.set(AlarmManager.RTC, System.currentTimeMillis() + 100, mPendingIntent);
System.exit(0);

// 출처: https://stackoverflow.com/questions/15564614/how-to-restart-an-android-application-programmatically
