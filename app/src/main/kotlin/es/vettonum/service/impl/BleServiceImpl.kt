package es.vettonum.service.impl

import android.content.Context
import com.polidea.rxandroidble2.RxBleClient
import com.polidea.rxandroidble2.scan.ScanSettings
import es.vettonum.service.BleService


class BleServiceImpl : BleService {

    /** Android Context */
    private val context: Context

    /** Ble library client */
    private val rxBleClient: RxBleClient

    /**
     * Constructor for BLE Service Impl class
     */
    constructor(context: Context) {
        this.context = context
        this.rxBleClient = RxBleClient.create(this.context)
    }

    override fun scanDevices() {
        val scanSubscription = rxBleClient.scanBleDevices(
            ScanSettings.Builder()
                .setScanMode(ScanSettings.SCAN_MODE_LOW_LATENCY) // change if needed
                .setCallbackType(ScanSettings.CALLBACK_TYPE_ALL_MATCHES) // change if needed
                .build()
            // add filters if needed
        )
            .subscribe(
                { scanResult ->
                    // Process scan result here.
                },
                { throwable ->
                    // Handle an error here.
                }
            )

        // When done, just dispose.
        scanSubscription.dispose()
    }

}
