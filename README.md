# Java sand

## 概要

Javaプログラミングの実験プロジェクト。

## 使い方

1. Eclispeのワークスペースフォルダの下で`git clone`
2. Eclipseのメニューから`Import`→`Existing Projects into Workspace`
3. Eclipseの`Package Explorer`でプロジェクトを右クリックして`Maven`→`Update project`
4. Eclipseの`Package Explorer`でプロジェクトを右クリックして`Run As`(または`Debug As`)→`Java Application`

`Main`クラスの中で、適当な`Sand`オブジェクトを作り、`run()`する。

## 実験内容

- `OptionalSand` ...`java.util.Optional`の使い方
- `UriSand` ...URL文字列を組み立てる方法
- `StaticSand` ...[`static`なフィールドやメソッドの使用例](doc/static.md)
- `ListSand` ...`java.util.List`の使い方
- `JacksonSand` ...Web APIのJSONレスポンスをjacksonライブラリでパースする
- `JunitSandTest` ...JUnitの使い方
- `JunitSandMockTest` ...Mockitoライブラリの使い方

## JUnit

`JunitSand`クラスのメソッドを、`JunitSandTest`でテストする。

- 依存ライブラリを追加
  - `junit-jupiter` ...テストプログラムを書くために必要
  - `junit-platform-launcher` ...テストプログラムを実行するために必要

- テストプログラムは、`test`ディレクトリの下に置いた
  - イレギュラーな場所なので、`pom.xml`経由でJUnitに教えてやる必要がある(`testSourceDirectory`)

- テストプログラムを書く(`JunitSandTest.java`)

- `Run As`→`JUnit Test`でテストを実行

## Mockito

`JunitSand`クラスの`guess()`メソッドは、素のJUnitではテストが書きにくい。モックの出番。

- 依存ライブラリを追加
  - `mockito-core`
  - `mockito-junit-jupiter`

- テストプログラムを書く(`JunitSandMockTest.java`)
