try {
    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$packageName")))
} catch (e: ActivityNotFoundException) {
    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$packageName")))
}
