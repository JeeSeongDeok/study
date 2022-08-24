final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
try {
    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
} catch (android.content.ActivityNotFoundException anfe) {
    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
}
