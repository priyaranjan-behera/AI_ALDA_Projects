SizeXTest = size(X_test);
XTestInstance = SizeXTest(1)
XTestAttributes = SizeXTest(2)

SizeXTrain= size(X_train);
XTrainInstance = SizeXTrain(1)
XTrainAttributes = SizeXTrain(2)

UniqueYTest = unique(Y_test);
UniqueYTestCount = size(UniqueYTest);

UniqueYTrain = unique(Y_train);
UniqueYTrainCount = size(UniqueYTrain);

MeanXTest = mean(X_test);
MeanXTrain = mean(X_train);

X_test_new = X_test;
X_train_new = X_train;

for i=1:XTestAttributes
    X_test_new(:,i) = X_test(:,i) - MeanXTrain(i);
    X_train_new(:,i) = X_train(:,i) - MeanXTrain(i); 
end

cov_X_test_new = cov(X_test_new);
cov_X_train_new = cov(X_train_new);


%eigVal_x_test = eig(cov_X_test_new);
%[eigVal_x_test_vec, eigVal_x_test_diag] = eig(cov_X_test_new); 
eigVal_x_train = eig(cov_X_train_new);
[eigVal_x_train_vec, eigVal_x_train_diag] = eig(cov_X_train_new);

figure(3)
plot(eigVal_x_train);
title('Plot of Eigen Values for Training Data');
xlabel('Eigen Value Id')
ylabel('Eigen Value')

reduced_test_data = X_test_new * eigVal_x_train_vec(:,63:64);
reduced_train_data = X_train_new * eigVal_x_train_vec(:,63:64);

scrsz = get(groot,'ScreenSize');
%figure('Position',[scrsz(3)*(1/4) scrsz(4)*(4/4) scrsz(3)*(2/4) scrsz(4)*(2/4)])
figure(1)
scatter(reduced_test_data(:,2), reduced_test_data(:,1), 50, Y_test, 'filled')
title('Plot of the testing data across the 1st and 2nd principal components')
xlabel('First Principal Component')
ylabel('Second Principal Component')
colorbar

scrsz = get(groot,'ScreenSize');
%figure('Position',[1 scrsz(4)/2 scrsz(3)/2 scrsz(4)/2])
figure(2)
scatter(reduced_train_data(:,2), reduced_train_data(:,1), 50, Y_train, 'filled')
title('Plot of the training data across the 1st and 2nd principal components')
xlabel('First Principal Component')
ylabel('Second Principal Component')
colorbar


classregtree(reduced_train_data, Y_test)