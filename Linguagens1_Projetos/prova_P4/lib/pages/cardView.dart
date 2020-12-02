import 'dart:convert';

import 'package:prova_P4/utility/NetworkHelper.dart';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:flutter/rendering.dart';


class cardView extends StatelessWidget {

  String pokemon;
  cardView({Key key, @required this.pokemon}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        backgroundColor: Colors.blue,
        body: Text("Nome: " + pokemon)
    );
  }
}