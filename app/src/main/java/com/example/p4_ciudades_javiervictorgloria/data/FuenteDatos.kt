package com.example.p4_ciudades_javiervictorgloria.data
// Importar modelos y recuersos
import com.example.p4_ciudades_javiervictorgloria.model.Ciudad
import com.example.p4_ciudades_javiervictorgloria.model.Lugar
import com.example.p4_ciudades_javiervictorgloria.R

object FuenteDatos {
    val ciudades = listOf(
        Ciudad(
            name = R.string.rotterdam,
            pais = R.string.holanda,
            continente = R.string.europa,
            imagen = R.drawable.img_rotterdam
        ),
        Ciudad(
            name = R.string.algeciras,
            pais = R.string.espana,
            continente = R.string.europa,
            imagen = R.drawable.img_algeciras
        ),

        Ciudad(
            name = R.string.oran,
            pais = R.string.argelia,
            continente = R.string.africa,
            imagen = R.drawable.img_oran
        ),

        Ciudad(
            name = R.string.santos,
            pais = R.string.brasil,
            continente = R.string.samerica,
            imagen = R.drawable.img_santos
        ),
        Ciudad(
            name = R.string.hong_kong,
            pais = R.string.china,
            continente = R.string.asia,
            imagen = R.drawable.img_hong_kong
        )

        )

    val lugares = listOf(
        // --- ROTTERDAM (ciudades[0]) ---
        Lugar(R.string.markthal, ciudades[0], R.drawable.img_markthal, R.string.desc_markthal),
        Lugar(R.string.casas_cubo, ciudades[0], R.drawable.img_casas_cubo, R.string.desc_casas_cubo),
        Lugar(R.string.puente_erasmo, ciudades[0], R.drawable.img_puente_erasmo, R.string.desc_puente_erasmo),
        Lugar(R.string.euromast, ciudades[0], R.drawable.img_euromast, R.string.desc_euromast),
        Lugar(R.string.zoo_rotterdam, ciudades[0], R.drawable.img_zoo, R.string.desc_zoo),

        // --- ALGECIRAS (ciudades[1]) ---
        Lugar(R.string.playa_getares, ciudades[1], R.drawable.img_getares, R.string.desc_getares),
        Lugar(R.string.plaza_alta, ciudades[1], R.drawable.img_plaza_alta, R.string.desc_plaza_alta),
        Lugar(R.string.parque_cristina, ciudades[1], R.drawable.img_parque, R.string.desc_parque),
        Lugar(R.string.puerto_algeciras, ciudades[1], R.drawable.img_puerto, R.string.desc_puerto),
        Lugar(R.string.mercado_abastos, ciudades[1], R.drawable.img_mercado, R.string.desc_mercado),

        // --- ORÁN (ciudades[2]) ---
        Lugar(R.string.fuerte_santa_cruz, ciudades[2], R.drawable.img_santa_cruz, R.string.desc_santa_cruz),
        Lugar(R.string.mezquita_pasha, ciudades[2], R.drawable.img_mezquita, R.string.desc_mezquita),
        Lugar(R.string.catedral_oran, ciudades[2], R.drawable.img_catedral, R.string.desc_catedral),
        Lugar(R.string.front_de_mer, ciudades[2], R.drawable.img_front_mer, R.string.desc_front_mer),
        Lugar(R.string.palacio_bey, ciudades[2], R.drawable.img_palacio_bey, R.string.desc_palacio_bey),

        // --- SANTOS (ciudades[3]) ---
        Lugar(R.string.museo_cafe, ciudades[3], R.drawable.img_museo_cafe, R.string.desc_museo_cafe),
        Lugar(R.string.jardin_playa, ciudades[3], R.drawable.img_jardin_santos, R.string.desc_jardin_santos),
        Lugar(R.string.monte_serrat, ciudades[3], R.drawable.img_monte_serrat, R.string.desc_monte_serrat),
        Lugar(R.string.estadio_santos, ciudades[3], R.drawable.img_vila_belmiro, R.string.desc_estadio),
        Lugar(R.string.acuario_santos, ciudades[3], R.drawable.img_acuario, R.string.desc_acuario),

        // --- HONG KONG (ciudades[4]) ---
        Lugar(R.string.victoria_peak, ciudades[4], R.drawable.img_victoria_peak, R.string.desc_victoria_peak),
        Lugar(R.string.buda_gigante, ciudades[4], R.drawable.img_buda, R.string.desc_buda),
        Lugar(R.string.star_ferry, ciudades[4], R.drawable.img_ferry, R.string.desc_ferry),
        Lugar(R.string.temple_street, ciudades[4], R.drawable.img_temple_market, R.string.desc_temple),
        Lugar(R.string.avenue_stars, ciudades[4], R.drawable.img_avenue_stars, R.string.desc_avenue_stars)
    )
}