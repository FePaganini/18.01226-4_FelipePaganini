import 'dart:convert';

import 'package:prova_P4/models/minhaCarta.dart';
import 'package:prova_P4/models/pokemonCard.dart';
import 'package:prova_P4/utility/NetworkHelper.dart';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:flutter/rendering.dart';


class cardView extends StatelessWidget {

  minhaCarta card;

  cardView({Key key, @required this.card}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        backgroundColor: Colors.blue,
        body: Stack(children: [
          Positioned(
            top: 5,
            left: 30,
            child: Text(card.name,
            style: TextStyle(fontSize: 30, height: 4, color: Colors.white),
            ),
          ),
          Center(child: Image.network(card.imageUrlHiRes)),
        ]),
    );
  }

}