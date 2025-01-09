# SuperSegurosPartners

SuperSegurosPartners es un SDK que muestra una interfaz para que tus usuarios puedan cotizar y contratar un Seguro de Auto de manera sencilla y rápida.
Este repositorio contiene todo lo necesario para integrar el SDK en tu proyecto Android.

# 1. Instalación

Paso 1. Agrega el repositorio JitPack a tu archivo de compilación:

allprojects {<br>
  repositories {<br>
    ...<br>
    maven { url 'https://jitpack.io' }<br>
  }<br>
}

Paso 2. Agrega la dependencia

dependencies {<br>
  implementation 'com.github.BoldBlueTechnologies:SuperSegurosPartners:${version}'<br>
}

# 2. Uso

El SDK ofrece un botón personalizado (SuperButton_superapi) que mostrará la interfaz de cotización y contratación. 

Integración por XML

Ejemplo:

<com.app.boldblue.superseguros.partners.SuperButton_superapi
android:layout_width="match_parent"
android:layout_height="wrap_content"/>

# 3. Requerimiento
   
Android: SDK 26 o superior.

# 4. Soporte
   
Si tienes dudas, sugerencias o problemas:

Abre un issue en este repositorio. O contacta al equipo de Bold Blue Technologies.
