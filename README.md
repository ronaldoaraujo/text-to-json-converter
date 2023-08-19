# Text to JSON Converter
![build](https://github.com/ronaldoaraujo/text-to-json-converter/actions/workflows/ci.yml/badge.svg)

This is a simple Java application that converts text files to JSON format. It processes input files containing data in a specific format and converts them to JSON files.

## Requirements

- Java 8 or higher
- Maven (for building the project)

## Usage

1. Clone the repository:

```sh
git clone https://github.com/ronaldoaraujo/text-to-json-converter.git
cd text-to-json-converter
```

2. Build the project using Maven:

```sh
mvn clean package
```

3. Run the application using the following command:
```sh
java -jar target/text-to-json-converter-1.0.jar <file or directory path>
```
Replace `<file or directory path>` with the path to the input text file or directory containing text files that you want to convert to JSON. The application will process the files and create corresponding JSON files in the same directory.

4. After running the application, you will find JSON files with the same names as the input text files, but with the .json extension.

## Example

Suppose you have a text file named `input.txt` with the following content:
```txt
0000000041                           Dr. Dexter Rolfson00000004470000000004     1159.8620210630
```
Running the application with the command:
```sh
java -jar target/text-to-json-converter-1.0.jar input.txt
```

Will generate a JSON file named `input.json` in the same directory with the following content:

```json
{
  "user_id": 41,
  "name": "Dr. Dexter Rolfson",
  "orders": [
    {
      "order_id": 447,
      "total": "1159.86",
      "date": "2021-06-30",
      "products": [
        {
          "product_id": 456,
          "value": "1159.86"
        }
      ]
    }
  ]
}
```

## Contributing

Contributions are welcome! If you find any issues or have improvements to suggest, please create a pull request.

## License

This project is licensed under the [MIT License](https://www.mit.edu/~amini/LICENSE.md).
