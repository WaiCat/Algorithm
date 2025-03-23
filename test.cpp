#include <iostream>
#include <fstream>
#include <vector>
#include <sstream>
#include <string>

using namespace std;

int main() {
    // 파일 이름
    string filename = "matrix_input.txt";
    
    // 입력 파일 스트림
    ifstream infile(filename);
    
    if (!infile.is_open()) {
        cerr << "파일을 열 수 없습니다: " << filename << endl;
        return 1;
    }

    // 행렬 저장용 2D 벡터
    vector<vector<int>> matrix;
    string line;

    // 한 줄씩 읽어서 처리
    while (getline(infile, line)) {
        vector<int> row;
        stringstream ss(line);
        int value;
        
        // 각 값을 읽어 행(row)에 추가
        while (ss >> value) {
            row.push_back(value);
        }
        
        // 행을 행렬에 추가
        if (!row.empty()) {
            matrix.push_back(row);
        }
    }

    infile.close();

    // 행렬 출력 확인
    cout << "행렬 내용:" << endl;
    for (const auto& row : matrix) {
        for (const auto& val : row) {
            cout << val << " ";
        }
        cout << endl;
    }

    return 0;
}
