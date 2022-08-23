 private WifiManager wifiManager;
    WifiConfiguration currentConfig;
    WifiManager.LocalOnlyHotspotReservation hotspotReservation;
    @SuppressLint("MissingPermission")
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void turnOnHotspot() {
        wifiManager = (WifiManager) this.getSystemService (this.WIFI_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            wifiManager.startLocalOnlyHotspot(new WifiManager.LocalOnlyHotspotCallback() {
                @Override
                public void onStarted(WifiManager.LocalOnlyHotspotReservation reservation) {
                    super.onStarted(reservation);
                    hotspotReservation = reservation;
                    currentConfig = hotspotReservation.getWifiConfiguration();

                    Log.v("DANG", "THE PASSWORD IS: "
                            + currentConfig.preSharedKey
                            + " \n SSID is : "
                            + currentConfig.SSID);
                }

                @Override
                public void onStopped() {
                    super.onStopped();
                    Log.v("DANG", "Local Hotspot Stopped");
                }

                @Override
                public void onFailed(int reason) {
                    super.onFailed(reason);
                    Log.v("DANG", "Local Hotspot failed to start");
                }
            }, new Handler());
        }
    }
