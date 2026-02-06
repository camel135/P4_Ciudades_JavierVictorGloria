
package com.example.p4_ciudades_javiervictorgloria.data
// Importar modelos y recuersos
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import com.example.p4_ciudades_javiervictorgloria.model.Ciudad
import com.example.p4_ciudades_javiervictorgloria.model.Lugar
import com.example.p4_ciudades_javiervictorgloria.R


object FuenteDatos {
    val ciudades = listOf(
        Ciudad(
            name = R.string.rotterdam,
            pais = R.string.holanda,
            continente = R.string.europa,
            imagen = R.drawable.proto_menu
        ),

        Ciudad(
            name = R.string.algeciras,
            pais = R.string.espana,
            continente = R.string.europa,
            imagen = R.drawable.proto_menu
        ),

        Ciudad(
            name = R.string.oran,
            pais = R.string.argelia,
            continente = R.string.africa,
            imagen = R.drawable.proto_menu
        ),

        Ciudad(
            name = R.string.santos,
            pais = R.string.brasil,
            continente = R.string.samerica,
            imagen = R.drawable.proto_menu
        ),
        Ciudad(
            name = R.string.hong_kong,
            pais = R.string.china,
            continente = R.string.asia,
            imagen = R.drawable.proto_menu
        )

        )

    val lugares = listOf(
        // --- ROTTERDAM (ciudades[0]) ---
        Lugar(R.string.markthal, ciudades[0], R.drawable.proto_menu, R.string.desc_markthal, R.string.restaurantes),
        Lugar(R.string.casas_cubo, ciudades[0], R.drawable.proto_menu, R.string.desc_casas_cubo, R.string.parques),
        Lugar(R.string.puente_erasmo, ciudades[0], R.drawable.proto_menu, R.string.desc_puente_erasmo, R.string.parques),
        Lugar(R.string.euromast, ciudades[0], R.drawable.proto_menu, R.string.desc_euromast, R.string.cafeterias),
        Lugar(R.string.zoo_rotterdam, ciudades[0], R.drawable.proto_menu, R.string.desc_zoo, R.string.parques),

        // --- ALGECIRAS (ciudades[1]) ---
        Lugar(R.string.playa_getares, ciudades[1], R.drawable.proto_menu, R.string.desc_getares, R.string.parques),
        Lugar(R.string.plaza_alta, ciudades[1], R.drawable.proto_menu, R.string.desc_plaza_alta, R.string.centros_comerciales),
        Lugar(R.string.parque_cristina, ciudades[1], R.drawable.proto_menu, R.string.desc_parque, R.string.parques),
        Lugar(R.string.puerto_algeciras, ciudades[1], R.drawable.proto_menu, R.string.desc_puerto, R.string.centros_comerciales),
        Lugar(R.string.mercado_abastos, ciudades[1], R.drawable.proto_menu, R.string.desc_mercado, R.string.restaurantes),

        // --- ORÁN (ciudades[2]) ---
        Lugar(R.string.fuerte_santa_cruz, ciudades[2], R.drawable.proto_menu, R.string.desc_santa_cruz, R.string.parques),
        Lugar(R.string.mezquita_pasha, ciudades[2], R.drawable.proto_menu, R.string.desc_mezquita, R.string.parques),
        Lugar(R.string.catedral_oran, ciudades[2], R.drawable.proto_menu, R.string.desc_catedral, R.string.centros_comerciales),
        Lugar(R.string.front_de_mer, ciudades[2], R.drawable.proto_menu, R.string.desc_front_mer, R.string.cafeterias),
        Lugar(R.string.palacio_bey, ciudades[2], R.drawable.proto_menu, R.string.desc_palacio_bey, R.string.restaurantes),

        // --- SANTOS (ciudades[3]) ---
        Lugar(R.string.museo_cafe, ciudades[3], R.drawable.proto_menu, R.string.desc_museo_cafe, R.string.cafeterias),
        Lugar(R.string.jardin_playa, ciudades[3], R.drawable.proto_menu, R.string.desc_jardin_santos, R.string.parques),
        Lugar(R.string.monte_serrat, ciudades[3], R.drawable.proto_menu, R.string.desc_monte_serrat, R.string.cafeterias),
        Lugar(R.string.estadio_santos, ciudades[3], R.drawable.proto_menu, R.string.desc_estadio, R.string.centros_comerciales),
        Lugar(R.string.acuario_santos, ciudades[3], R.drawable.proto_menu, R.string.desc_acuario, R.string.parques),

        // --- HONG KONG (ciudades[4]) ---
        Lugar(R.string.victoria_peak, ciudades[4], R.drawable.proto_menu, R.string.desc_victoria_peak, R.string.parques),
        Lugar(R.string.buda_gigante, ciudades[4], R.drawable.proto_menu, R.string.desc_buda, R.string.parques),
        Lugar(R.string.star_ferry, ciudades[4], R.drawable.proto_menu, R.string.desc_ferry, R.string.restaurantes),
        Lugar(R.string.temple_street, ciudades[4], R.drawable.proto_menu, R.string.desc_temple, R.string.centros_comerciales),
        Lugar(R.string.avenue_stars, ciudades[4], R.drawable.proto_menu, R.string.desc_avenue_stars, R.string.parques)
    )

    val categoriasOpciones = listOf(
        Pair(R.string.restaurantes, R.drawable.outline_ramen_dining_24),
        Pair(R.string.parques, R.drawable.outline_forest_24),
        Pair(R.string.centros_comerciales, R.drawable.outline_shopping_bag_24),
        Pair(R.string.cafeterias, R.drawable.outline_local_cafe_24)


    )
}
