#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

#define DEPTH_SIZE 127
#define PARAM_SIZE 100
#define STRING_SIZE 12800




void test_main(char answer[STRING_SIZE], const char question[STRING_SIZE]) {
    char operand1[STRING_SIZE] = "";
    char operand2[STRING_SIZE] = "";
    bool isOper1Negative = false;
    bool isOper2Negative = false;

    int len = strlen(question);
    int i = 0;
    int operandIndex = 0;
    bool firstOperand = true;
    char operatorChar = '\0';

    while (i < len) {
        if (question[i] == '+' || question[i] == '-') {
            // 연산자를 만난 경우
            if (firstOperand) {
                if(question[i] == '+')
                {
                    isOper1Negative = false;
                }
                else
                {
                    isOper1Negative = true;
                }
                operand1[operandIndex] = '\0';
                firstOperand = false;
                operatorChar = question[i];
                operandIndex = 0;
            }
            else {
                if (question[i] == '+')
                {
                    isOper2Negative = false;
                }
                else
                {
                    isOper2Negative = true;
                }
                // 두 번째 연산자를 만났으므로, calculate 함수 호출
                operand2[operandIndex] = '\0';

                // 26진법 계산 로직
                int lenA = strlen(operand1);
                int lenB = strlen(operand2);
                int len = (lenA > lenB) ? lenA : lenB;
                int coefficientsA[128] = { 0 };
                int coefficientsB[128] = { 0 };

                // 배열 초기화
                for (int j = 0; j < lenA; j++) {
                    coefficientsA[lenA - j - 1] = operand1[j] - 'A';
                }
                for (int j = 0; j < lenB; j++) {
                    coefficientsB[lenB - j - 1] = operand2[j] - 'A';
                }

                char result[STRING_SIZE] = "";                

                if (!isOper1Negative && !isOper2Negative) { // add a + b
                    int carry = 0;
                    for (int j = 0; j < len || carry; j++) {
                        int sum = coefficientsA[j] + coefficientsB[j] + carry;
                        coefficientsA[j] = sum % 26;
                        carry = sum / 26;
                    }
                    for (int j = len - 1; j >= 0; j--) {
                        if (j == len - 1 && coefficientsA[j] == 0) continue;
                        result[strlen(result)] = 'A' + coefficientsA[j];
                    }
                }
                else if (!isOper1Negative && isOper2Negative) { // sub a - b
                    bool isNegative = false;
                    if (lenA < lenB || (lenA == lenB && strcmp(operand1, operand2) < 0)) {
                        isNegative = true;
                        for (int j = 0; j < len; j++) {
                            if (coefficientsB[j] < coefficientsA[j]) {
                                coefficientsB[j] += 26;
                                coefficientsB[j + 1]--;
                            }
                            coefficientsB[j] -= coefficientsA[j];
                        }
                    }
                    else {
                        for (int j = 0; j < len; j++) {
                            if (coefficientsA[j] < coefficientsB[j]) {
                                coefficientsA[j] += 26;
                                coefficientsA[j + 1]--;
                            }
                            coefficientsA[j] -= coefficientsB[j];
                        }
                    }
                    for (int j = len - 1; j >= 0; j--) {
                        if (j == len - 1 && coefficientsA[j] == 0) continue;
                        result[strlen(result)] = 'A' + coefficientsA[j];
                    }
                    isCurrentNegative = isNegative;
                }
                else if (isOper1Negative && !isOper2Negative) { // sub b - a
                    bool isNegative = false;
                    if (lenB < lenA || (lenB == lenA && strcmp(operand2, operand1) < 0)) {
                        isNegative = true;
                        for (int j = 0; j < len; j++) {
                            if (coefficientsA[j] < coefficientsB[j]) {
                                coefficientsA[j] += 26;
                                coefficientsA[j + 1]--;
                            }
                            coefficientsA[j] -= coefficientsB[j];
                        }
                    }
                    else {
                        for (int j = 0; j < len; j++) {
                            if (coefficientsB[j] < coefficientsA[j]) {
                                coefficientsB[j] += 26;
                                coefficientsB[j + 1]--;
                            }
                            coefficientsB[j] -= coefficientsA[j];
                        }
                    }
                    for (int j = len - 1; j >= 0; j--) {
                        if (j == len - 1 && coefficientsB[j] == 0) continue;
                        result[strlen(result)] = 'A' + coefficientsB[j];
                    }
                    isCurrentNegative = !isNegative;
                }
                else { // add -(a + b)
                    int carry = 0;
                    for (int j = 0; j < len || carry; j++) {
                        int sum = coefficientsA[j] + coefficientsB[j] + carry;
                        coefficientsA[j] = sum % 26;
                        carry = sum / 26;
                    }
                    for (int j = len - 1; j >= 0; j--) {
                        if (j == len - 1 && coefficientsA[j] == 0) continue;
                        result[strlen(result)] = 'A' + coefficientsA[j];
                    }
                    isCurrentNegative = true;
                }


                // 다음 연산을 위해 operand1에 result를 복사
                strncpy(operand1, result, STRING_SIZE);
                operand1[STRING_SIZE - 1] = '\0';  // 안전하게 문자열 종료 보장
                operandIndex = 0;
                operatorChar = question[i];
            }
            i++;
            continue;
        }

        if (firstOperand) {
            operand1[operandIndex++] = question[i];
        }
        else {
            operand2[operandIndex++] = question[i];
        }
        i++;
    }

    // 마지막 연산자 후의 계산을 위해
    if (!firstOperand) {
        operand2[operandIndex] = '\0';
        char result[STRING_SIZE] = "";
        // 여기에 마지막 연산 로직을 추가하면 됩니다.
    }

    // 결과를 answer에 저장
    strncpy(answer, operand1, STRING_SIZE);
}

static bool check_data(char answer[STRING_SIZE], const char question[STRING_SIZE]) {
	return true;
}

static char* make_rand_number_to_string(void) {
	static char str[DEPTH_SIZE + 1];
	str[0] = (rand() % 25) + 'B';
	int depth = (rand() % DEPTH_SIZE) + 1;

	for (int i = 1; i < depth; i++) {
		str[i] = (rand() % 26) + 'A';
	}
	str[depth] = 0;

	return str;
}

static void build_data(char question[STRING_SIZE]) {
	strcpy_s(question, STRING_SIZE, make_rand_number_to_string());
	int count = (rand() % (PARAM_SIZE - 1)) + 2;

	for (int i = 1; i < count; i++) {
		(rand() % 2 == 0) ? strcat_s(question, STRING_SIZE, "+") : strcat_s(question, STRING_SIZE, "-");
		strcat_s(question, STRING_SIZE, make_rand_number_to_string());
	}
}

int main(void) {
	unsigned int SCORE = 0;

	for (int i = 0; i < 100; i++) {
		char question[STRING_SIZE];
		build_data(question);
		char answer[STRING_SIZE];
		char answer2[STRING_SIZE];
		unsigned int t = clock();		
        test_main(answer, question);
		SCORE += (clock() - t);

		if (check_data(answer, question) == false) {
			SCORE += 1000000;
		}
	}

	printf("SCORE = %d\n", SCORE);
	return 0;
}

