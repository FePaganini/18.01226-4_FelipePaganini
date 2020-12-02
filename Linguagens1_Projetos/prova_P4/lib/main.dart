import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

//Import de páginas
import 'package:prova_P4/pages/cardSearch.dart';

void main(){
  runApp(MaterialApp(
    initialRoute: '/',
    routes: {
      '/': (context) => cardSearch(),
    },
  ),
  );
}
