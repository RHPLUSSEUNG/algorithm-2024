
const char* calculateHexavigesimal(char* A, char* B, bool is, bool is2)
{
	
	//26진법 계산 A:0 ~ Z:25	
	int lenA = sizeof(A);
	int lenB = sizeof(B);
	int len;

	int coefficientsA[128] = { 0 };
	int coefficientsB[128] = { 0 };

	int isANegative = false;
	int isBNegative = false;

	char ouput[DEPTH_SIZE];

	if (lenA > lenB)
	{
		len = lenA + 1;
	}
	else
	{
		len = lenB + 1;
	}	
	
	for (int i = 0; i < lenA; i++)
	{
		coefficientsA[lenA - i - 1] = A[i] - 'A';
	}
	for (int i = 0; i < lenB; i++)
	{
		coefficientsB[lenB - i - 1] = B[i] - 'A';
	}

    char result[STRING_SIZE] = "";         
	
	if (!isANegative && !isBNegative) //add a+b 결과는 무조건 양수
	{
		int carry = 0;
		for (int i = 0; i < len; i++)
		{
			int sum = coefficientsA[i] + coefficientsB[i] + carry;
			coefficientsA[i] = sum % 26;
			carry = sum / 26;
		}
		
		for (int i = len - 1; i >= 0; i--)
		{
			if (i == len - 1 && coefficientsA[i] == 0) continue;
			result[strlen(result)] = 'A' + coefficientsA[j];
		}
	}
	else if (!isANegative && isBNegative) //sub a-b
	{
		if (lenA < lenB) // a < b(-) 결과는 무조건 음수
		{			
			for (int i = 0; i < lenB; i++)
			{
				if (coefficientsB[i] < coefficientsA[i])
				{
					coefficientsB[i] += 26;
					coefficientsB[i + 1]--;
				}
				coefficientsB[i] -= coefficientsA[i];
			}
	
			for (int i = lenB - 1; i >= 0; i--)
			{
				output = static_cast<char>('A' + coefficientsB[i]) + output;
			}

			if (output[lenB - 1] == 'A') {
				output.erase(1, lenB - 1);
			}

			isCurrentNegative = true;
		}
		else if (lenA == lenB) // b(-) == a
		{
			if (A[lenA - 1] > B[lenB - 1]) //a > b(-) 결과는 무조건 양수
			{
				for (int i = 0; i < lenA; i++)
				{
					if (coefficientsA[i] < coefficientsB[i])
					{
						coefficientsA[i] += 26;
						coefficientsA[i + 1]--;
					}
					coefficientsA[i] -= coefficientsB[i];
				}
				
				for (int i = lenA - 1; i >= 0; i--)
				{
					output = static_cast<char>('A' + coefficientsA[i]) + output;
				}

				if (output[lenA - 1] == 'A') {
					output.erase(1, lenA - 1);
				}

				isCurrentNegative = false;
			}
			else //a < b(-) 결과는 무조건 음수
			{
				for (int i = 0; i < lenB; i++)
				{
					if (coefficientsB[i] < coefficientsA[i])
					{
						coefficientsB[i] += 26;
						coefficientsB[i + 1]--;
					}
					coefficientsB[i] -= coefficientsA[i];
				}
				
				for (int i = lenB - 1; i >= 0; i--)
				{
					output = static_cast<char>('A' + coefficientsB[i]) + output;
				}

				if (output[lenB - 1] == 'A') {
					output.erase(1, lenB - 1);
				}

				isCurrentNegative = true;
			}
		}
		else // a > b(-) 결과는 무조건 양수
		{
			for (int i = 0; i < lenA; i++)
			{
				if (coefficientsA[i] < coefficientsB[i])
				{
					coefficientsA[i] += 26;
					coefficientsA[i + 1]--;
				}
				coefficientsA[i] -= coefficientsB[i];
			}
			
			for (int i = lenA - 1; i >= 0; i--)
			{
				output = static_cast<char>('A' + coefficientsA[i]) + output;
			}

			if (output[lenA - 1] == 'A') {
				output.erase(1, lenA - 1);
			}
			isCurrentNegative = false;
		}
	}
	else if (isANegative && !isBNegative) //sub b-a
	{
		if (lenA > lenB) // a > b(-) 결과는 무조건 음수
		{
			for (int i = 0; i < lenA; i++)
			{
				if (coefficientsA[i] < coefficientsB[i])
				{
					coefficientsA[i] += 26;
					coefficientsA[i + 1]--;
				}
				coefficientsA[i] -= coefficientsB[i];
			}
			
			for (int i = lenA - 1; i >= 0; i--)
			{
				output = static_cast<char>('A' + coefficientsA[i]) + output;
			}

			if (output[lenA - 1] == 'A') {
				output.erase(1, lenA - 1);
			}
			isCurrentNegative = true;
		}
		else if (lenA == lenB) // b(-) == a
		{
			if (A[lenA - 1] < B[lenB - 1]) //a < b(-) 결과는 무조건 양수
			{
				for (int i = 0; i < lenB; i++)
				{
					if (coefficientsB[i] < coefficientsA[i])
					{
						coefficientsB[i] += 26;
						coefficientsB[i + 1]--;
					}
					coefficientsB[i] -= coefficientsA[i];
				}
				
				for (int i = lenB - 1; i >= 0; i--)
				{
					output = static_cast<char>('A' + coefficientsB[i]) + output;
				}

				if (output[lenB - 1] == 'A') {
					output.erase(1, lenB - 1);
				}

				isCurrentNegative = false;
			}
			else //a > b(-) 결과는 무조건 음수
			{
				for (int i = 0; i < lenA; i++)
				{
					if (coefficientsA[i] < coefficientsB[i])
					{
						coefficientsA[i] += 26;
						coefficientsA[i + 1]--;
					}
					coefficientsA[i] -= coefficientsB[i];
				}
				
				for (int i = lenA - 1; i >= 0; i--)
				{
					output = static_cast<char>('A' + coefficientsA[i]) + output;
				}

				if (output[lenA - 1] == 'A') {
					output.erase(1, lenA - 1);
				}
				isCurrentNegative = true;
			}
		}
		else // a < b(-) 결과는 무조건 양수
		{
			for (int i = 0; i < lenB; i++)
			{
				if (coefficientsB[i] < coefficientsA[i])
				{
					coefficientsB[i] += 26;
					coefficientsB[i + 1]--;
				}
				coefficientsB[i] -= coefficientsA[i];
			}
			
			for (int i = lenB - 1; i >= 0; i--)
			{
				output = static_cast<char>('A' + coefficientsB[i]) + output;
			}

			if (output[lenB - 1] == 'A') {
				output.erase(1, lenB - 1);
			}

			isCurrentNegative = false;
		}

	}
	else //add -(a+b) 결과는 무조건 음수
	{
		int carry = 0;
		for (int i = 0; i < len; i++)
		{
			int sum = coefficientsA[i] + coefficientsB[i] + carry;
			coefficientsA[i] = sum % 26;
			carry = sum / 26;
		}
	
		for (int i = len - 1; i >= 0; i--)
		{
			if (i == len - 1 && coefficientsA[i] == 0) continue;
			output = static_cast<char>('A' + coefficientsA[i]) + output;
		}

		isCurrentNegative = true;
	}

	std::cout << "The result is " << output << std::endl;
	return output;
}


void test_main(char answer[STRING_SIZE], const char question[STRING_SIZE]) {
	
	char operand1[STRING_SIZE] = "";
	char operand2[STRING_SIZE] = "";
	bool isOper1Negative = false;
	bool isOper2Negative = false;

	int len = sizeof(question);
	int i = 0;
	int operandIndex = 0;
	bool firstOperand = true;
	char operatorChar = '\0';

	while (i < len) {
		if (question[i] == '+' || question[i] == '-') {
			// 연산자를 만난 경우
			if (firstOperand) {
				operand1[operandIndex] = '\0';
				firstOperand = false;
				operatorChar = question[i];
				operandIndex = 0;
			}
			else {
				// 두 번째 연산자를 만났으므로, calculate 함수 호출
				operand2[operandIndex] = '\0';
				//

#pragma region Calc
				//26진법 계산 A:0 ~ Z:25	
				int lenA = sizeof(operand1);
				int lenB = sizeof(operand12);
				int len;

				int coefficientsA[128] = { 0 };
				int coefficientsB[128] = { 0 };

				char ouput[DEPTH_SIZE];

				if (lenA > lenB)
				{
					len = lenA + 1;
				}
				else
				{
					len = lenB + 1;
				}

				for (int i = 0; i < lenA; i++)
				{
					coefficientsA[lenA - i - 1] = A[i] - 'A';
				}
				for (int i = 0; i < lenB; i++)
				{
					coefficientsB[lenB - i - 1] = B[i] - 'A';
				}

				if (!isOper1Negative && !isOper2Negative) //add a+b 결과는 무조건 양수
				{
					int carry = 0;
					for (int i = 0; i < len; i++)
					{
						int sum = coefficientsA[i] + coefficientsB[i] + carry;
						coefficientsA[i] = sum % 26;
						carry = sum / 26;
					}

					for (int i = len - 1; i >= 0; i--)
					{
						if (i == len - 1 && coefficientsA[i] == 0) 
						{
							continue;
						}
						operand1[i] = 'A' + coefficientsA[i];
					}
				}
				else if (!isOper1Negative && isOper2Negative) //sub a-b
				{
					if (lenA < lenB) // a < b(-) 결과는 무조건 음수
					{
						for (int i = 0; i < lenB; i++)
						{
							if (coefficientsB[i] < coefficientsA[i])
							{
								coefficientsB[i] += 26;
								coefficientsB[i + 1]--;
							}
							coefficientsB[i] -= coefficientsA[i];
						}

						for (int i = lenB - 1; i >= 0; i--)
						{
							output = static_cast<char>('A' + coefficientsB[i]) + output;
						}

						if (output[lenB - 1] == 'A') {
							output.erase(1, lenB - 1);
						}

						isCurrentNegative = true;
					}
					else if (lenA == lenB) // b(-) == a
					{
						if (A[lenA - 1] > B[lenB - 1]) //a > b(-) 결과는 무조건 양수
						{
							for (int i = 0; i < lenA; i++)
							{
								if (coefficientsA[i] < coefficientsB[i])
								{
									coefficientsA[i] += 26;
									coefficientsA[i + 1]--;
								}
								coefficientsA[i] -= coefficientsB[i];
							}

							for (int i = lenA - 1; i >= 0; i--)
							{
								output = static_cast<char>('A' + coefficientsA[i]) + output;
							}

							if (output[lenA - 1] == 'A') {
								output.erase(1, lenA - 1);
							}

							isCurrentNegative = false;
						}
						else //a < b(-) 결과는 무조건 음수
						{
							for (int i = 0; i < lenB; i++)
							{
								if (coefficientsB[i] < coefficientsA[i])
								{
									coefficientsB[i] += 26;
									coefficientsB[i + 1]--;
								}
								coefficientsB[i] -= coefficientsA[i];
							}

							for (int i = lenB - 1; i >= 0; i--)
							{
								output = static_cast<char>('A' + coefficientsB[i]) + output;
							}

							if (output[lenB - 1] == 'A') {
								output.erase(1, lenB - 1);
							}

							isCurrentNegative = true;
						}
					}
					else // a > b(-) 결과는 무조건 양수
					{
						for (int i = 0; i < lenA; i++)
						{
							if (coefficientsA[i] < coefficientsB[i])
							{
								coefficientsA[i] += 26;
								coefficientsA[i + 1]--;
							}
							coefficientsA[i] -= coefficientsB[i];
						}

						for (int i = lenA - 1; i >= 0; i--)
						{
							output = static_cast<char>('A' + coefficientsA[i]) + output;
						}

						if (output[lenA - 1] == 'A') {
							output.erase(1, lenA - 1);
						}
						isCurrentNegative = false;
					}
				}
				else if (isANegative && !isBNegative) //sub b-a
				{
					if (lenA > lenB) // a > b(-) 결과는 무조건 음수
					{
						for (int i = 0; i < lenA; i++)
						{
							if (coefficientsA[i] < coefficientsB[i])
							{
								coefficientsA[i] += 26;
								coefficientsA[i + 1]--;
							}
							coefficientsA[i] -= coefficientsB[i];
						}

						for (int i = lenA - 1; i >= 0; i--)
						{
							output = static_cast<char>('A' + coefficientsA[i]) + output;
						}

						if (output[lenA - 1] == 'A') {
							output.erase(1, lenA - 1);
						}
						isCurrentNegative = true;
					}
					else if (lenA == lenB) // b(-) == a
					{
						if (A[lenA - 1] < B[lenB - 1]) //a < b(-) 결과는 무조건 양수
						{
							for (int i = 0; i < lenB; i++)
							{
								if (coefficientsB[i] < coefficientsA[i])
								{
									coefficientsB[i] += 26;
									coefficientsB[i + 1]--;
								}
								coefficientsB[i] -= coefficientsA[i];
							}

							for (int i = lenB - 1; i >= 0; i--)
							{
								output = static_cast<char>('A' + coefficientsB[i]) + output;
							}

							if (output[lenB - 1] == 'A') {
								output.erase(1, lenB - 1);
							}

							isCurrentNegative = false;
						}
						else //a > b(-) 결과는 무조건 음수
						{
							for (int i = 0; i < lenA; i++)
							{
								if (coefficientsA[i] < coefficientsB[i])
								{
									coefficientsA[i] += 26;
									coefficientsA[i + 1]--;
								}
								coefficientsA[i] -= coefficientsB[i];
							}

							for (int i = lenA - 1; i >= 0; i--)
							{
								output = static_cast<char>('A' + coefficientsA[i]) + output;
							}

							if (output[lenA - 1] == 'A') {
								output.erase(1, lenA - 1);
							}
							isCurrentNegative = true;
						}
					}
					else // a < b(-) 결과는 무조건 양수
					{
						for (int i = 0; i < lenB; i++)
						{
							if (coefficientsB[i] < coefficientsA[i])
							{
								coefficientsB[i] += 26;
								coefficientsB[i + 1]--;
							}
							coefficientsB[i] -= coefficientsA[i];
						}

						for (int i = lenB - 1; i >= 0; i--)
						{
							output = static_cast<char>('A' + coefficientsB[i]) + output;
						}

						if (output[lenB - 1] == 'A') {
							output.erase(1, lenB - 1);
						}

						isCurrentNegative = false;
					}

				}
				else //add -(a+b) 결과는 무조건 음수
				{
					int carry = 0;
					for (int i = 0; i < len; i++)
					{
						int sum = coefficientsA[i] + coefficientsB[i] + carry;
						coefficientsA[i] = sum % 26;
						carry = sum / 26;
					}

					for (int i = len - 1; i >= 0; i--)
					{
						if (i == len - 1 && coefficientsA[i] == 0) continue;
						output = static_cast<char>('A' + coefficientsA[i]) + output;
					}

					isCurrentNegative = true;
				}
#pragma endregion


				// 다음 연산을 위해 operand1에 result를 복사
				strncpy(operand1, result, STRING_SIZE);
				for (int i = 0; i < STRING_SIZE; i++)
				{
					operand1
				}
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
		char* result = calculateHexavigesimal(operand1, operand2, isOper1Negative, isOper2Negative);
		std::cout << "Final Result: " << result << std::endl;
	}
	/*const char* p;
	bool isFirst = true;	
	char operand1[DEPTH_SIZE];
	char operand2[DEPTH_SIZE];
	
	int operand1_count = 0;
	int operand2_count = 0;

	char currentOperator = NULL;
	char nextOperator = NULL;

	bool isOper1Negative = false;
	bool isOper2Negative = false;

	bool isCalc = false;

	for (int i = 0; i < sizeof(question); i++)
	{		
		if (question[i] != '+' || question[i] != '-')
		{
			if (isFirst)
			{
				operand1[operand1_count] = question[i];
				operand1_count++;
			}			
			else
			{
				operand2[operand2_count] = question[i];
				operand2_count++;
			}
		}
		else
		{
			if (isFirst)
			{
				isFirst = false;
			}

			if (question[i] != '+')
			{				
				isOper2Negative = false;
				if (isCalc)
				{

				}
			}
			else
			{
				isOper2Negative = true;
				if (isCalc)
				{

				}
			}
		}
		
	}*/
}