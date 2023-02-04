package data_source.taipei_zoo

import javax.inject.Inject

class TaipeiZooDataSource @Inject constructor(
    taipeiZooServices: TaipeiZooServices
) : ITaipeiZooDataSource {
}