package es.vettonum

import android.app.Application
import com.github.salomonbrys.kodein.*
import es.vettonum.service.BleService
import es.vettonum.service.impl.BleServiceImpl

class App : Application(), KodeinAware {


    override val kodein by Kodein.lazy {

        val kodein: Kodein = Kodein {
            bind<BleService>() with singleton {
                BleServiceImpl(this@App)
            }
        }
    }
}